/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Camilo
 */
public class Logica {

    public int dadoNuevo() {
        return (int) ((Math.random() * 6) + 1);
    }

    public void ganador(String ganador) {
        System.out.println("El ganador es: " + ganador);
        System.exit(0);
    }

    public boolean apostar() {
        return (Math.random() * 2) + 1 == 1;

    }

    public int aleatorio(int min, int max) {
        return (int) (Math.random() * max) + min;
    }

    public int apostarDinero(int dinero, int apuestaMin, int mesa) {
        if (dinero >= mesa) {
            if (mesa > apuestaMin) {
                return aleatorio(apuestaMin, mesa);
            } else {
                return aleatorio(1, mesa);
            }
        } else {
            return aleatorio(apuestaMin, dinero);
        }
    }

    public void jugar(int dado, int dinero1, int dinero2, int apuestaMin, int mesa, int jugador, int nuevoDado, int apuesta) {
        if (dinero1 <= 0 || dinero2 <= 0) {
            if (dinero1 <= 0) {
                ganador("Jugador 2");
            } else {
                ganador("Jugador 1");
            }

        } else {
            System.out.println("El dinero en la mesa es: " + mesa);
            if (mesa <= 0) {
                System.out.println("No hay dinero en la mesa, ambos apuestan: " + apuestaMin);
                jugar(dadoNuevo(), dinero1 - apuestaMin, dinero2 - apuestaMin, apuestaMin, (mesa + (apuestaMin * 2)), jugador, dadoNuevo(), apuesta);
            }
            if (jugador == 1) {
                System.out.println("Turno del jugador 1 " + "Su dinero es: " + dinero1 + " Dado = " + dado);
                if (dado == 2 || dado == 3 || dado == 4 || dado == 5) {
                    if (apostar() == false) {
                        System.out.println("No apostara");
                        jugar(dadoNuevo(), dinero1, dinero2, apuestaMin, mesa, ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, mesa));

                    } else {
                        System.out.println("Jugador apuesta: " + apuesta);
                        System.out.println("Saca: " + nuevoDado);
                        if (dado >= nuevoDado) {
                            System.out.println("Pierde: " + apuesta);
                            jugar(dadoNuevo(), (dinero1 - apuesta), dinero2, apuestaMin, (mesa + apuesta), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, (mesa + apuesta)));
                        } else {
                            System.out.println("Gana: " + apuesta);
                            jugar(dadoNuevo(), (dinero1 + apuesta), dinero2, apuestaMin, (mesa - apuesta), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, (mesa - apuesta)));

                        }
                    }
                } else {
                    if (dado == 1) {
                        System.out.println("El jugador debe poner: " + apuesta);
                        jugar(dadoNuevo(), (dinero1 - apuestaMin), dinero2, apuestaMin, (mesa + apuestaMin), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, (mesa + apuestaMin)));
                    } else {
                        System.out.println("El jugador debe sacar: " + apuestaMin + " de la mesa.");

                        if (mesa < apuestaMin) {
                            System.out.println("El dinero en la mesa es menor que la apuesta minima, se retira todo el dinero");
                            jugar(dadoNuevo(), (dinero1 + mesa), dinero2, apuestaMin, (0), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, 0));
                        } else {
                            jugar(dadoNuevo(), (dinero1 + apuestaMin), dinero2, apuestaMin, (mesa - apuestaMin), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, (mesa - apuestaMin)));
                        }
                    }
                }

            } else {
                System.out.println("Turno del jugador 2 " + "Su dinero es: " + dinero2 + " Dado = " + dado);
                if (dado == 2 || dado == 3 || dado == 4 || dado == 5) {
                    if (apostar() == false) {
                        System.out.println("No apostara");
                        jugar(dadoNuevo(), dinero1, dinero2, apuestaMin, mesa, ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero2, apuestaMin, mesa));
                    } else {
                        System.out.println("Jugador apuesta: " + apuesta);
                        System.out.println("Saca: " + nuevoDado);
                        if (dado >= nuevoDado) {
                            System.out.println("Pierde: " + apuesta);
                            jugar(dadoNuevo(), dinero1, (dinero2 - apuesta), apuestaMin, (mesa + apuesta), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero1, apuestaMin, (mesa + apuesta)));
                        } else {
                            System.out.println("Gana: " + apuesta);
                            jugar(dadoNuevo(), dinero1, (dinero2 + apuesta), apuestaMin, (mesa - apuesta), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero1, apuestaMin, (mesa - apuesta)));
                        }
                    }

                } else {
                    if (dado == 1) {
                        System.out.println("El jugador debe poner: " + apuesta);
                        jugar(dadoNuevo(), dinero1, (dinero2 - apuestaMin), apuestaMin, (mesa + apuestaMin), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero1, apuestaMin, (mesa + apuestaMin)));
                    } else {
                        System.out.println("El jugador debe sacar: " + apuestaMin + " de la mesa.");
                        if (mesa < apuestaMin) {
                            System.out.println("El dinero en la mesa es menor que la apuesta minima, se retira todo el dinero");
                            jugar(dadoNuevo(), dinero1, (dinero2 + mesa), apuestaMin, (0), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero1, apuestaMin, 0));
                        } else {
                            jugar(dadoNuevo(), dinero1, (dinero2 + apuestaMin), apuestaMin, (mesa - apuestaMin), ((jugador + 1) % 2), dadoNuevo(), apostarDinero(dinero1, apuestaMin, (mesa - apuestaMin)));
                        }
                    }
                }
            }
        }
    }
}
