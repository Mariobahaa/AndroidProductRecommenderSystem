package com.example.recomendationsystem.Values

 class VALUES {
     companion object {
        var ALL_BEAUTY_PATH:String = "F:\\FCIS\\4th year\\GP\\GP Datasets\\All Beauty\\All_Beauty_5.json.gz"
        var ARTCRAFTS_PATH:String= "F:\\FCIS\\4th year\\GP\\GP Datasets\\Arts Crafts\\Arts_Crafts_and_Sewing_5.json.gz"
        var SOFTWARE_PATH :String= "F:\\FCIS\\4th year\\GP\\GP Datasets\\Software\\Software.json.gz"
        var ELECTRONICS_PATH:String= "F:\\FCIS\\4th year\\GP\\GP Datasets\\All Beauty\\Electronics_5.json.gz"

        var USER_FAKE_ID:Float = -1f
        var USER_REAL_ID:String = ""

        var AMAZON_PORT:Int = 5001
        var COLLABORATIVE_PORT:Int = 5002
        var MODEL_PORT:Int = 5003
         var USER_PORT:Int = 5004

         var COLLABORATIVE_RESPONSE_KEY:String = "Collaborative response"
         var CATEGORY_Path_KEY:String = "Category Path"


         val CATEGORY_TITLES = arrayOf("All Beauty", "Arts and Crafts", "Electronics", "Software")
         val CATEGORY_PATHES = arrayOf("F:\\FCIS\\4th year\\GP\\GP Datasets\\All Beauty\\All_Beauty_5.json.gz",
                                       "F:\\FCIS\\4th year\\GP\\GP Datasets\\Arts Crafts\\Arts_Crafts_and_Sewing_5.json.gz",
             "F:\\FCIS\\4th year\\GP\\GP Datasets\\All Beauty\\Electronics_5.json.gz",
             "F:\\FCIS\\4th year\\GP\\GP Datasets\\Software\\Software.json.gz")

         var ALL_BEAUTY_TITLE = "All Beauty"
         var ARTS_CRAFTS_TITLE = "Arts and Crafts"
         var ELECTRONICS_TITLE = "Electronics"
         var SOFTWARE_TITLE = "Software"

     }
 }