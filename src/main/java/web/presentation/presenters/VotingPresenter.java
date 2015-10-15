package web.presentation.presenters;

import rest.business.controllers.BusinessController;
import rest.business.views.TransferObject1;
import web.presentation.models.Model;

public class VotingPresenter {
    //Mostrar votaciones
    public String process(Model model){
        model.put("log", "VotingPresenter:process");
      //Necesito que se devuelva un array con nombre de tema y su media
        //Media de votaciones();
        return "VotingView";
    }
    
    //Acción de votar
    public String voteTheme(Model model){
        model.put("log", "VotingPresenter:vote");
        //crear un metodo en la clase de negocio al que le pase un voto
        new BusinessController().m1(new TransferObject1());
        return "VotingView";
    }
}
