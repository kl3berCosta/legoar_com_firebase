package com.legoar.di;

import com.legoar.data.db.AppDatabase;
import com.legoar.data.db.BrickDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideBrickDaoFactory implements Factory<BrickDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideBrickDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public BrickDao get() {
    return provideBrickDao(dbProvider.get());
  }

  public static AppModule_ProvideBrickDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideBrickDaoFactory(dbProvider);
  }

  public static BrickDao provideBrickDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBrickDao(db));
  }
}
