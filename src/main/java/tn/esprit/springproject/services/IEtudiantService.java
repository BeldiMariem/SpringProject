package tn.esprit.springproject.services;

import tn.esprit.springproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public Etudiant getEtudiantById(int id);

    public List<Etudiant> getAllEtudiants();

    public Etudiant addEtudiant(Etudiant e);

    public Etudiant updateEtudiant(Etudiant e);

    public void deleteEtudiant(int id);
    public List<Etudiant> findByPrenomEContains(String prenom);

    public void assignEtudiantToDepartement (int etudiantId, int departementId) ;

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int idEquipe);

    List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

}
