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
public final class ProjectViewModel_Factory implements Factory<ProjectViewModel> {
  private final Provider<BrickRepository> repositoryProvider;

  public ProjectViewModel_Factory(Provider<BrickRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ProjectViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static ProjectViewModel_Factory create(Provider<BrickRepository> repositoryProvider) {
    return new ProjectViewModel_Factory(repositoryProvider);
  }

  public static ProjectViewModel newInstance(BrickRepository repository) {
    return new ProjectViewModel(repository);
  }
}
