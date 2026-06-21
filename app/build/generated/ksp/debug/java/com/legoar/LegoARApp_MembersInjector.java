package com.legoar;

import com.legoar.data.firebase.FirebaseRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class LegoARApp_MembersInjector implements MembersInjector<LegoARApp> {
  private final Provider<FirebaseRepository> firebaseRepositoryProvider;

  public LegoARApp_MembersInjector(Provider<FirebaseRepository> firebaseRepositoryProvider) {
    this.firebaseRepositoryProvider = firebaseRepositoryProvider;
  }

  public static MembersInjector<LegoARApp> create(
      Provider<FirebaseRepository> firebaseRepositoryProvider) {
    return new LegoARApp_MembersInjector(firebaseRepositoryProvider);
  }

  @Override
  public void injectMembers(LegoARApp instance) {
    injectFirebaseRepository(instance, firebaseRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.legoar.LegoARApp.firebaseRepository")
  public static void injectFirebaseRepository(LegoARApp instance,
      FirebaseRepository firebaseRepository) {
    instance.firebaseRepository = firebaseRepository;
  }
}
