package web.presentation.presenters;

import java.util.ArrayList;
import java.util.List;

import rest.business.controllers.BusinessController;
import rest.business.views.ThemeAverageTransfer;
import rest.business.views.VoteTransfer;
import web.presentation.models.Model;

public class VotingPresenter {
    
    //Mostrar votaciones
    public List<String> process(){
        List<ThemeAverageTransfer> themeAverages = new BusinessController().getAverages();
        List<String> averagesList = new ArrayList<>();
        for(int i=0; i<themeAverages.size(); i++){
            averagesList.add("[themeName="+themeAverages.get(i).getThemeName()+", average="+themeAverages.get(i).getAverage()+"]");
        }
        return averagesList;
        //Necesito que se devuelva un array con nombre de tema y su media
        //Media de votaciones();
        
    }
    
    //Acción de votar
    public void voteTheme(Model model){
        new BusinessController().voteTheme(new VoteTransfer((String)model.get("themeName"),(int)model.get("vote")));
        
    }
}
