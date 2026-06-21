package com.legoar.data.repository;

import com.legoar.data.db.BrickDao;
import com.legoar.data.db.ProjectDao;
import com.legoar.data.firebase.FirebaseRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class BrickRepository_Factory implements Factory<BrickRepository> {
  private final Provider<ProjectDao> projectDaoProvider;

  private final Provider<BrickDao> brickDaoProvider;

  private final Provider<FirebaseRepository> firebaseProvider;

  public BrickRepository_Factory(Provider<ProjectDao> projectDaoProvider,
      Provider<BrickDao> brickDaoProvider, Provider<FirebaseRepository> firebaseProvider) {
    this.projectDaoProvider = projectDaoProvider;
    this.brickDaoProvider = brickDaoProvider;
    this.firebaseProvider = firebaseProvider;
  }

  @Override
  public BrickRepository get() {
    return newInstance(projectDaoProvider.get(), brickDaoProvider.get(), firebaseProvider.get());
  }

  public static BrickRepository_Factory create(Provider<ProjectDao> projectDaoProvider,
      Provider<BrickDao> brickDaoProvider, Provider<FirebaseRepository> firebaseProvider) {
    return new BrickRepository_Factory(projectDaoProvider, brickDaoProvider, firebaseProvider);
  }

  public static BrickRepository newInstance(ProjectDao projectDao, BrickDao brickDao,
      FirebaseRepository firebase) {
    return new BrickRepository(projectDao, brickDao, firebase);
  }
}
