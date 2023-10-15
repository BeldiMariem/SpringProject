package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Departement;
import tn.esprit.springproject.entities.Equipe;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repository.ContratRepository;
import tn.esprit.springproject.repository.DepartementRepository;
import tn.esprit.springproject.repository.EquipeRepository;
import tn.esprit.springproject.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiantService{


    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    DepartementRepository departementRepository;
    @Override
    public Etudiant getEtudiantById(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(int id) {
           etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> findByPrenomEContains(String prenom) {
        return etudiantRepository.findByPrenomEContains(prenom);
    }

    @Override
    public void assignEtudiantToDepartement(int etdId, int departementId) {
        Etudiant etd = etudiantRepository.findById(etdId).orElse(null);
        Departement dep = departementRepository.findById(departementId).orElse(null);
        etd.setDepartement(dep);
        etudiantRepository.save(etd);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, int idContrat, int idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiants().add(e);
        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
      return etudiantRepository.findByDepartementIdDepart(idDepartement);
    }


}
