package com.survey.project.application.features.shared.otherClasses

object ProvenceZoneDistrict {

     val listOfProvence = HashMap<String, List<String>>()
     val listOfZone = HashMap<String, List<String>>()

    private var noZone :MutableList<String> = ArrayList()
    private var listOfZone1 :MutableList<String> = arrayListOf<String>()
    private var listOfZone2 :MutableList<String> = arrayListOf<String>()
    private var listOfZone3 :MutableList<String> = arrayListOf<String>()

    private var noDistrict :MutableList<String> = ArrayList()
    private var listOfDistrict1 :MutableList<String> = ArrayList()
    private var listOfDistrict2 :MutableList<String> = ArrayList()
    private var listOfDistrict3 :MutableList<String> = ArrayList()
    private var listOfDistrict4 :MutableList<String> = ArrayList()
    private var listOfDistrict5 :MutableList<String> = ArrayList()
    private var listOfDistrict6 :MutableList<String> = ArrayList()


    fun setProvence(){
        setZone()
//        listOfProvence["Choose Provence"] = noZone
        listOfProvence["1"] = listOfZone1
        listOfProvence["2"] = listOfZone2
        listOfProvence["3"] = listOfZone3


    }

     private fun setZone() {
//        noZone.add("Choose Zone")

        listOfZone1.add("Mechi")
        listOfZone1.add("Koshi")
        listOfZone1.add("Sagarmatha")

        listOfZone2.add("Janakpur")
        listOfZone2.add("Bagmati")
        listOfZone2.add("Lumbini")

        listOfZone3.add("A")
        listOfZone3.add("B")
        listOfZone3.add("C")

    }

    fun zone(){
        setDistrict()
//        listOfZone["Choose Zone"] = noDistrict

        listOfZone["Mechi"] = listOfDistrict1
        listOfZone["Koshi"] = listOfDistrict2
        listOfZone["Sagarmatha"] = listOfDistrict3


        listOfZone["Janakpur"] = listOfDistrict4
        listOfZone["Bagmati"] = listOfDistrict5
        listOfZone["Lumbini"] = listOfDistrict6

    }

     private fun setDistrict(){
//         noDistrict.add("Choose District")
         listOfDistrict1.add("Illam1")
         listOfDistrict1.add("Illam2")
         listOfDistrict1.add("Illam3")

         listOfDistrict2.add("Sagarmatha1")
         listOfDistrict2.add("Sagarmatha2")
         listOfDistrict2.add("Sagarmatha3")

         listOfDistrict3.add("Ktm1")
         listOfDistrict3.add("Ktm2")
         listOfDistrict3.add("Ktm3")

         listOfDistrict4.add("pkr1")
         listOfDistrict4.add("pkr2")
         listOfDistrict4.add("pkr3")

         listOfDistrict5.add("brj1")
         listOfDistrict5.add("brj2")
         listOfDistrict5.add("brj3")

         listOfDistrict6.add("1231")
         listOfDistrict6.add("1232")
         listOfDistrict6.add("1233")

    }


}