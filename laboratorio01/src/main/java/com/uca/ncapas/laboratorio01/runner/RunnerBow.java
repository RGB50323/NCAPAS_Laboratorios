package com.uca.ncapas.laboratorio01.runner;

import com.uca.ncapas.laboratorio01.model.Bow;
import com.uca.ncapas.laboratorio01.service.BowService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerBow implements CommandLineRunner {

    private final BowService bowService;

    public RunnerBow(BowService bowService) {
        this.bowService = bowService;
    }

    @Override
    public void run(String... args) {

        System.out.println("========= FILTRO POR VIRUS T-VIRUS =========");
        bowService.filtrarPorVirus("T-Virus").forEach(this::imprimirReporte);

        System.out.println("========= FILTRO POR ESTADO EN LIBERTAD =========");
        bowService.filtrarPorEstado("En libertad").forEach(this::imprimirReporte);

        System.out.println("========= VIRUS ACTIVOS SIN REPETICION =========");
        bowService.virusActivosSinRepeticion()
                .forEach(virus -> System.out.println("[S.T.A.R.S-REPORT] Virus activo: " + virus));
    }

    private void imprimirReporte(Bow bow) {
        System.out.println("[S.T.A.R.S-REPORT] Nombre: " + bow.getNombre()
                + " | Nivel de Peligro: " + bow.getNivelPeligro()
                + " | Punto Débil: " + bow.getPuntoDebil());
    }
}