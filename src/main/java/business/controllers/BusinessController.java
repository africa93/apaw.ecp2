package business.controllers;

import business.models.daos.DaoFactory;
import business.views.TransferObject1;
import business.views.TransferObject2;

public class BusinessController {
    
    public void m2(TransferObject2 transferObject2){
        DaoFactory.getFactory().getVoteDao().read(1);
    }

    public void m1(TransferObject1 transferObject1) {
        DaoFactory.getFactory().getThemeDao().findAll();
    }

    public void createTheme(TransferObject2 transferObject2) {
        
    }
}
