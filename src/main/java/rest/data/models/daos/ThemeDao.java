package rest.data.models.daos;

import java.util.List;

import rest.business.models.entities.Theme;


public interface ThemeDao extends GenericDao<Theme,Integer> {
    public List<String> findAllNames();
    public Theme findByName(String themeName);
}
