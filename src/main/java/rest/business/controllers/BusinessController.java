package rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import rest.business.models.entities.Theme;
import rest.business.models.entities.Vote;
import rest.business.views.ThemeAverageTransfer;
import rest.business.views.VoteTransfer;
import rest.data.models.daos.DaoFactory;

public class BusinessController {

    public void voteTheme(VoteTransfer voteTransfer) {
        int id = DaoFactory.getFactory().getVoteDao().findAll().size() + 1;
        Theme t = DaoFactory.getFactory().getThemeDao().findByName(voteTransfer.getThemeName());
        DaoFactory.getFactory().getVoteDao().create(new Vote(id, voteTransfer.getVote(), t));
    }

    public void createTheme(String themeName) {
        int id = DaoFactory.getFactory().getThemeDao().findAll().size() + 1;
        DaoFactory.getFactory().getThemeDao().create(new Theme(id, themeName));
    }

    public List<String> getThemes() {
        return DaoFactory.getFactory().getThemeDao().findAllNames();
    }

    public List<ThemeAverageTransfer> getAverages() {
        List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        List<ThemeAverageTransfer> themeAverageTransfer = new ArrayList<>();
        for (int i = 0; i < themes.size(); i++) {
            List<Vote> votes = DaoFactory.getFactory().getVoteDao().findByTheme(themes.get(i));
            double average = getAverage(votes);
            themeAverageTransfer.add(new ThemeAverageTransfer(themes.get(i).getName(), average));
        }
        return themeAverageTransfer;
    }

    private double getAverage(List<Vote> votes) {
        double sum = 0;
        for (int i = 0; i < votes.size(); i++) {
            sum += votes.get(i).getVote();
        }
        return sum / votes.size();
    }
}
