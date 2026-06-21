# LegoAR — Integração Firebase

## O que foi alterado

### Erros corrigidos
| Arquivo | Problema | Correção |
|---|---|---|
| `build.gradle.kts` (raiz) | Plugin `google-services` ausente | Adicionado com `apply false` |
| `app/build.gradle.kts` | Plugin `google-services` não aplicado no módulo app | Adicionado `alias(libs.plugins.google.services)` |
| `app/build.gradle.kts` | Conflito de META-INF com Firebase | `excludes += "META-INF/INDEX.LIST"` |
| `AppModule.kt` | Room sem `fallbackToDestructiveMigration` (crash em dev) | Adicionado |
| `AndroidManifest.xml` | `ACCESS_NETWORK_STATE` ausente (Firebase precisa) | Adicionado |
| `LegoARApp.kt` | Firebase não inicializado antes do uso | `FirebaseApp.initializeApp(this)` |
| `ArModule.kt` | Módulo vazio com import desnecessário de `BrickRepository` | Limpado |

### Novos arquivos
| Arquivo | Função |
|---|---|
| `FirebaseRepository.kt` | Operações Firestore (projetos + peças) e Auth anônimo |
| `FirebaseModule.kt` | Módulo Hilt que provê `FirebaseFirestore`, `FirebaseAuth`, `FirebaseStorage` |
| `BrickRepository.kt` | Reescrito com estratégia offline-first (Room + Firebase) |
| `google-services.json.TEMPLATE` | Template com instruções para configurar seu projeto |
| `firestore.rules` | Regras de segurança prontas para deploy |
| `res/xml/network_security_config.xml` | Config de rede segura |
| `gradle/libs.versions.toml` | Firebase BOM + dependências adicionadas |

---

## Como configurar (passo a passo)

### 1. Criar projeto Firebase
1. Acesse [console.firebase.google.com](https://console.firebase.google.com)
2. **Criar projeto** → nome: "LegoAR" (ou qualquer nome)
3. Google Analytics: opcional

### 2. Adicionar o app Android
1. No projeto, clique **Adicionar app → Android**
2. **Package name:** `com.legoar`
3. Apelido: "LegoAR Android"
4. Baixe o `google-services.json` gerado
5. **Coloque em:** `app/google-services.json` (substitui o `.TEMPLATE`)

### 3. Ativar serviços

#### Authentication
1. Console → **Authentication → Começar**
2. Aba **Provedores de login**
3. Habilite **Anônimo** (obrigatório)
4. Opcional: habilite **Google** para login real

#### Firestore
1. Console → **Firestore Database → Criar banco de dados**
2. Comece em **modo de teste** (30 dias)
3. Escolha a região mais próxima (ex.: `southamerica-east1`)
4. Após criar, vá em **Regras** e publique o conteúdo de `firestore.rules`

#### Storage (thumbnails — opcional)
1. Console → **Storage → Começar**
2. Modo de teste por enquanto

### 4. Build
```bash
./gradlew assembleDebug
```

---

## Estrutura de dados no Firestore

```
users/
  {uid}/
    projects/
      {projectId}/
        name: "Construção 1"
        createdAt: 1234567890
        updatedAt: 1234567890
        thumbnailPath: null
        
        bricks/
          {brickId}/
            type: "BRICK_2x4"
            color: "RED"
            gridX: 5
            gridY: 0
            gridZ: 3
            rotationY: 0
```

---

## Estratégia offline-first

```
Usuário faz ação
      │
      ▼
  Room (local)  ←── fonte de verdade imediata
      │
      ▼ (assíncrono, fire-and-forget)
  Firestore     ←── sincronização em nuvem
```

- O app **nunca bloqueia** a UI esperando o Firebase
- Se sem internet, tudo funciona normalmente
- Quando voltar online, o Firebase **sincroniza automaticamente** graças ao `setPersistenceEnabled(true)`
- O cache local do Firestore (`CACHE_SIZE_UNLIMITED`) garante que dados recentes sejam lidos mesmo offline

---

## Dependências adicionadas

```toml
# Firebase BOM (versão 33.5.1)
firebase-bom           = "com.google.firebase:firebase-bom"
firebase-firestore     = "com.google.firebase:firebase-firestore-ktx"
firebase-auth          = "com.google.firebase:firebase-auth-ktx"
firebase-storage       = "com.google.firebase:firebase-storage-ktx"
firebase-analytics     = "com.google.firebase:firebase-analytics-ktx"
firebase-crashlytics   = "com.google.firebase:firebase-crashlytics-ktx"

# Plugins
google-services        = "com.google.gms:google-services:4.4.2"
firebase-crashlytics   = "com.google.firebase:firebase-crashlytics-gradle:3.0.2"
```
