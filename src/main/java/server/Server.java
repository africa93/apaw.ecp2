package server;

import voting.http.HttpMethod;
import voting.http.HttpRequest;
import voting.http.HttpResponse;
import voting.http.HttpStatus;
import web.presentation.frontController.FrontController;

public class Server {

    public HttpResponse send(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        if (HttpMethod.GET.equals(request.getMethod())) {
            new FrontController().doGet(request, response);
        } else if (HttpMethod.POST.equals(request.getMethod())) {
            new FrontController().doPost(request, response);
        }
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
