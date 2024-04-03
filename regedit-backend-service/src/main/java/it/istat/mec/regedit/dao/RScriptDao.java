package it.istat.mec.regedit.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RScriptDao {
	
	@Autowired
    private EntityManager em;
	// Return a Map Values
    public Map<?, ?> crossTable(Long idelaborazione, LinkedHashMap<String, ArrayList<String>> ruoliVariabileNome)
            throws Exception {

        Map<String, ArrayList<String>> worksetOut = new LinkedHashMap<String, ArrayList<String>>();
        // <codRuolo,[namevar1,namevar2..]

        ArrayList<String> variabileNomeList = new ArrayList<>();

        final StringBuilder selectFieldsbuilder = new StringBuilder();
        ruoliVariabileNome.values().forEach((list) -> {
            selectFieldsbuilder.append(String.join(",", list));
            selectFieldsbuilder.append(",");
            variabileNomeList.addAll(list);
        });
        return null;
    }
}
