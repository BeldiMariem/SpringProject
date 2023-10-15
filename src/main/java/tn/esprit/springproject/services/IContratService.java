package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    public Contrat getContratById(int id);

    public List<Contrat> getAllContrats();

    public Contrat addContrat(Contrat c);

    public Contrat updateContrat(Contrat c);

    public void deleteContrat(int id);

    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);

    Integer nbContratsValides(Date startDate, Date endDate);

    public String getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
}
