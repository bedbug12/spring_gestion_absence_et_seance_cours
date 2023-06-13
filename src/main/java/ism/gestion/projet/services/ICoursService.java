package ism.gestion.projet.services;

import ism.gestion.projet.entities.Cours;

import java.util.List;
import java.util.stream.Stream;

public interface ICoursService {

    public Stream<Integer> nbHeureDerouleRestante(Long id);
    public List<Cours> listCoursProf(Long id);
    public List<Cours> listCoursEtu(Long id);

}
