package org.iesch.a04_marcador_de_basket.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// MVVM 1 - Hemos de extender de ViewModel
public class MainViewModel extends ViewModel {

    // MVVM 2 - Cortar y pegar variables del main
        //LD 1 - Cambio el tipo de variable
    private MutableLiveData<Integer> localScore = new MutableLiveData<>();
    private MutableLiveData<Integer> visitorScore = new MutableLiveData<>();

    // LV 5 - Se crea un constructor ya que se inicializan a nulo
    public MainViewModel() {
        ResetScore();
    }

    //LV 2 - Se cambia la forma de leer los valores
    public MutableLiveData<Integer>  getLocalScore() {
        return localScore;
    }

    public MutableLiveData<Integer>  getVisitorScore() {
        return visitorScore;
    }

    //MVVM 3 - Traigo los metodos del main sin tocar los views
        //LD Se cambia la forama de establecer los valores
    public void ResetScore() {
        localScore.setValue(0);
        visitorScore.setValue(0);
    }

        // LD 4 - Cambia forma de restar y sumar a las variables
    public void addPointsToScore(int point, boolean isLocal) {
        if (isLocal) {
            localScore.setValue(localScore.getValue()+point);
        } else {
            visitorScore.setValue(localScore.getValue()+point);
        }
    }

    // MVVM 4 - MEtodos para sumar y decrementar los scores
    public void decreaseLocal() {
        if (localScore.getValue() > 0) localScore.setValue(localScore.getValue()-1);
    }

    public void decreaseVisitor() {
        if (visitorScore.getValue() > 0) visitorScore.setValue(visitorScore.getValue()-1);
    }


}
