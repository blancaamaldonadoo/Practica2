package Interfaces;

import ClasesLab.Experimento;

public interface ManejadorLaboratorio {
    public void crearExperimento();
    public Experimento cambiarNombreExperimento(Experimento experimento);
    public void addExperimento(Experimento e);
    public void eliminarExperimento(Experimento e);
    public Experimento getExperimentoActual();
}