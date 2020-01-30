/*
 * Copyright 2020 Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Locale;

/**
 *
 * @author Sebastian Najarro Heredia - sebastian.najarro.alum@iescamp.es
 */
public class Mandocleta implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final double DEF_VELOCIDAD = 0;

    public static final double MAX_VELOCIDAD = 1.5;

    private double velocidad;

    public Mandocleta() {
        velocidad = DEF_VELOCIDAD;
    }

    public Mandocleta(double velocidad) {

        if (validar(velocidad)) {
            this.velocidad = velocidad;
        } else {
            this.velocidad = DEF_VELOCIDAD;
        }
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        if (validar(velocidad)) {
            this.velocidad = velocidad;
        }
    }

    @Override
    public final boolean equals(Object o) {
        boolean testOK;
        if (o == null) {
            testOK = false;
        } else if (!(o instanceof Mandocleta)) {
            testOK = false;
        } else {
            testOK = velocidad == ((Mandocleta) o).getVelocidad();
        }
        return testOK;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.velocidad) ^ (Double.doubleToLongBits(this.velocidad) >>> 32));
        return hash;
    }

    @Override
    public final String toString() {

  return String.format(Locale.ENGLISH,"%s - %.2f", getClass().getSimpleName(),
          velocidad);

    }

    public boolean validar(double velocidad) {
        return velocidad <= MAX_VELOCIDAD;
    }

}
