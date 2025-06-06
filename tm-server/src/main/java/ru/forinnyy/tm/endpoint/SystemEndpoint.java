package ru.forinnyy.tm.endpoint;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import ru.forinnyy.tm.api.endpoint.ISystemEndpoint;
import ru.forinnyy.tm.api.service.IPropertyService;
import ru.forinnyy.tm.api.service.IServiceLocator;
import ru.forinnyy.tm.dto.request.ApplicationAboutRequest;
import ru.forinnyy.tm.dto.request.ApplicationVersionRequest;
import ru.forinnyy.tm.dto.response.ApplicationAboutResponse;
import ru.forinnyy.tm.dto.response.ApplicationVersionResponse;

public final class SystemEndpoint implements ISystemEndpoint {

    @NonNull
    private final IServiceLocator serviceLocator;

    public SystemEndpoint(@NonNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @NonNull
    private IPropertyService getPropertyService() {
        return serviceLocator.getPropertyService();
    }

    @NotNull
    @Override
    public ApplicationAboutResponse getAbout(@NotNull final ApplicationAboutRequest request) {
        @NonNull final ApplicationAboutResponse response = new ApplicationAboutResponse();
        response.setEmail(getPropertyService().getAuthorEmail());
        response.setName(getPropertyService().getAuthorName());
        response.setGitBranch(getPropertyService().getGitBranch());
        response.setGitCommitId(getPropertyService().getGitCommitId());
        response.setGitCommitMessage(getPropertyService().getGitCommitMessage());
        response.setGitCommitTime(getPropertyService().getGitCommitTime());
        response.setGitCommitterName(getPropertyService().getGitCommitterName());
        response.setGitCommitterEmail(getPropertyService().getGitCommitterEmail());
        return response;
    }

    @NotNull
    @Override
    public ApplicationVersionResponse getVersion(@NotNull final ApplicationVersionRequest request) {
        @NonNull final ApplicationVersionResponse response = new ApplicationVersionResponse();
        response.setVersion(getPropertyService().getApplicationVersion());
        return response;
    }

}
