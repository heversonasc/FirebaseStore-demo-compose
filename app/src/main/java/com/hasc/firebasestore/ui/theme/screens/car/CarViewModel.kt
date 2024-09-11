package com.hasc.firebasestore.ui.theme.screens.car

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import com.google.firebase.ktx.Firebase
import com.hasc.firebasestore.domain.model.Car
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CarViewModel : ViewModel(){

    private var _car = MutableStateFlow<Car?>(null)
    var car = _car.asStateFlow()

    init {
        getCarByID()
    }

    fun getCarByID() {
        var db = Firebase.firestore

        db.collection("cars")
            .document("ATqYD6fb2nYlIpWIeEig")
            .get()
            .addOnSuccessListener { documentSnapshot ->
                _car.value = documentSnapshot.toObject()
            }

    }

}