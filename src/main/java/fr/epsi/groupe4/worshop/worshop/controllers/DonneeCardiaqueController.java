package fr.epsi.groupe4.worshop.worshop.controllers;

import fr.epsi.groupe4.worshop.worshop.beans.DonneeCardique;
import fr.epsi.groupe4.worshop.worshop.services.DonneeCardiaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donnee")
public class DonneeCardiaqueController {

    @Autowired
    private DonneeCardiaqueService donneeCardiaqueService;

    public DonneeCardiaqueController(DonneeCardiaqueService donneeCardiaqueService) {
        this.donneeCardiaqueService = donneeCardiaqueService;
    }

    @GetMapping("/liste")
    public List<DonneeCardique> listeDonnee(){
        return donneeCardiaqueService.listeDonnee();
    }

    @PostMapping("/ajouter")
    public String ajouterDonnee(@Validated @RequestBody DonneeCardique donneeCardique)
    {
        donneeCardiaqueService.ajouterDonnee(donneeCardique);

        return "donnee cardiaque ajouter avec sucess";
    }

    @PutMapping("/{id_donnee}/update")
    public String updateDonnee(@Validated @PathVariable int id_donnee, @RequestBody DonneeCardique donneeCardique)
    {
        donneeCardiaqueService.updateDonnee(id_donnee, donneeCardique);

        return "mise à jour donnee cardiaque avec sucess";
    }

    @DeleteMapping("/{id_donnee}/delete")
    public String removeDonnee(@Validated @PathVariable int id_donnee)
    {
        donneeCardiaqueService.removeDonnee(id_donnee);
        return "suppression de la donnee avec success";
    }

    @GetMapping("/{id_donnee}/searchById")
    public DonneeCardique searchByIdDonnee(@Validated @PathVariable int id_donnee)
    {
        return donneeCardiaqueService.searchByIdDonnee(id_donnee);
    }



}
