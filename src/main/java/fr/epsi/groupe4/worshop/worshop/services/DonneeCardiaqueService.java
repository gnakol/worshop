package fr.epsi.groupe4.worshop.worshop.services;

import fr.epsi.groupe4.worshop.worshop.beans.DonneeCardique;
import fr.epsi.groupe4.worshop.worshop.repository.DonneeCardiaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonneeCardiaqueService {

    @Autowired
    private DonneeCardiaqueRepository donneeCardiaqueRepository;

    public DonneeCardiaqueService(DonneeCardiaqueRepository donneeCardiaqueRepository) {
        this.donneeCardiaqueRepository = donneeCardiaqueRepository;
    }

    public List<DonneeCardique> listeDonnee()
    {
        return this.donneeCardiaqueRepository.findAll();
    }

    public void ajouterDonnee(DonneeCardique donneeCardique)
    {
        donneeCardiaqueRepository.save(donneeCardique);
    }

    public DonneeCardique updateDonnee(int id_donnee, DonneeCardique donneeCardique)
    {
        return donneeCardiaqueRepository.findById(id_donnee)
                .map(p->{
                    p.setDate(donneeCardique.getDate());
                    p.setRythme_cardiaque(donneeCardique.getRythme_cardiaque());
                    return donneeCardiaqueRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("desoler donner non trouver"));
    }

    public void removeDonnee(int id_donnee)
    {
        DonneeCardique donneeCardique = donneeCardiaqueRepository.findById(id_donnee).orElseThrow();

        if(donneeCardique != null)
        {
            donneeCardiaqueRepository.delete(donneeCardique);
        }
    }

    public DonneeCardique searchByIdDonnee(int id_donnee)
    {
        return  donneeCardiaqueRepository.findById(id_donnee).get();
    }
}
