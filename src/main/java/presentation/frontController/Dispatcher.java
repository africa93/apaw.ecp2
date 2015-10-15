package presentation.frontController;

import presentation.models.Model;
import presentation.presenters.ThemeManagerPresenter;
import presentation.presenters.VotingPresenter;
import presentation.views.ErrorView;
import presentation.views.ThemeManagerView;
import presentation.views.View;
import presentation.views.VotingView;
import voting.http.HttpRequest;
import voting.http.HttpResponse;


public class Dispatcher {
    
    Model model = new Model();
    
    public void doGet(HttpRequest request, HttpResponse response){
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";
        
        switch(presenter){
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            nextView = votingPresenter.process(model);
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            nextView = themeManagerPresenter.process(model);
            break;
        }
        this.show(nextView, model);
    }
    
    public void doPost(HttpRequest request, HttpResponse response){
        String controller = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String name = request.getParams().get("themeName");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "VotingPresenter":
            VotingPresenter votingPresenter = new VotingPresenter();
            if ("voteTheme".equals(action)) {
                nextView = votingPresenter.voteTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "ThemeManagerPresenter":
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            if ("createTheme".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = themeManagerPresenter.createTheme(model,name);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }
    
    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "VotingView":
            view = new VotingView();
            break;
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }
}
