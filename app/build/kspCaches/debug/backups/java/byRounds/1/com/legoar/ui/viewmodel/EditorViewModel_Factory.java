package com.legoar.ui.viewmodel;

import com.legoar.data.repository.BrickRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class EditorViewModel_Factory implements Factory<EditorViewModel> {
  private final Provider<BrickRepository> repositoryProvider;

  public EditorViewModel_Factory(Provider<BrickRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public EditorViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static EditorViewModel_Factory create(Provider<BrickRepository> repositoryProvider) {
    return new EditorViewModel_Factory(repositoryProvider);
  }

  public static EditorViewModel newInstance(BrickRepository repository) {
    return new EditorViewModel(repository);
  }
}
