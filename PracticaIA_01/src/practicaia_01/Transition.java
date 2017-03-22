/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaia_01;

import practicaia_01.State.Position;

/**
 *
 * @author cristel
 */
public class Transition {

    public enum Action {

        Mover_Oveja, Mover_Repollos, Mover_Lobo, Mover_Granjero
    }
    public State initial;
    public Action action;

    public State doTransition() {
        State result = new State();
        if (action == Action.Mover_Granjero) {
            result.oveja = initial.oveja;
            result.repollos = initial.repollos;
            result.lobo = initial.lobo;
            if (initial.granjero == Position.DERECHA) 
                result.granjero = Position.IZQUIERDA;
             else 
                result.granjero = Position.DERECHA;
            }
         if (action == Action.Mover_Oveja) {
             if (initial.oveja == Position.DERECHA) 
                result.oveja = Position.IZQUIERDA;
             else 
            result.granjero = Position.DERECHA;
            result.repollos = initial.repollos;
            result.lobo = initial.lobo;
            if (initial.granjero == Position.DERECHA) 
                result.granjero = Position.IZQUIERDA;
             else 
                result.granjero = Position.DERECHA;
        }
        return result;
    }
    public Transition(State initial, Action action) {
        this.initial = initial;
        this.action = action;
    }
}

