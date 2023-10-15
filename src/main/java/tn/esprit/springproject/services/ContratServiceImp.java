package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entities.Contrat;
import tn.esprit.springproject.entities.Etudiant;
import tn.esprit.springproject.repository.ContratRepository;
import tn.esprit.springproject.repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImp implements IContratService{

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public Contrat getContratById(int id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public void deleteContrat(int id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce,String nomE,String prenomE) {
        Contrat contrat = contratRepository.findById(ce.getIdContrat()).orElse(null);
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        if (contratRepository.countByEtudiantIdEtudiantAndArchive(etudiant.getIdEtudiant(),false)<5){
            contrat.setEtudiant(etudiant);
        }
        return contratRepository.save(contrat);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        Integer i = 0;
        List<Contrat> listContrat = contratRepository.findAll();
        for (Contrat c: listContrat) {
            if(((c.getDateDebutContrat().after(startDate))||(c.getDateDebutContrat().equals(startDate)))
                    && ((c.getDateFinContrat().before(endDate)) ||(c.getDateFinContrat().equals(endDate)))
                    && c.getArchive()== false){
                i++;
            }
        }
        return i;
    }

    @Override
    public String getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float chiffre=0;
        float chiffreIA=0;
        float chiffreRESAUX=0;
        float chiffreCLOUD=0;
        float chiffreSECURITE=0;
        List<Contrat> lc = contratRepository.ListContratBetweenToDate(startDate,endDate);
        for(Contrat c : lc){

            if(c.getSpecialite().toString().equals("IA")){
                chiffreIA = chiffreIA + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("CLOUD")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("SECURITE")){
                chiffreCLOUD = chiffreCLOUD + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            if(c.getSpecialite().toString().equals("RESEAUX")){
                chiffreRESAUX = chiffreRESAUX + c.getMontantContrat();
                System.out.println("******** Ia ="+chiffreIA);
            }
            chiffre = chiffre + c.getMontantContrat();

        }
        String ch ="Pour un contrat dont la spécialité est IA: "+chiffreIA+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est RESEAUX: "+chiffreRESAUX+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est CLOUD: "+chiffreCLOUD+"Dt/mois\n" +
                "Pour un contrat dont la spécialité est SECURITE: "+chiffreSECURITE+"Dt/mois\n";
        return ch;
    }

}
