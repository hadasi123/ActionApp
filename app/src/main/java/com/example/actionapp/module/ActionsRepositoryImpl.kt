package com.example.actionapp.module

class ActionsRepositoryImpl: ActionsRepository {
    override fun loadActions(): Array<Action> {

        /*
        * If I was to use an http call, the code would look somewhat like the code below,
        * and I would have to declare retrofit endpoints
        * For the task, we use mocked data

        val client = RetrofitClient()

        override fun loadActions(): Array<Action> {

            var resultList : Actions? = null

            val actionsCallback = object : Callback<Actions> {

              override fun onFailure(call: Call<Actions>?, t: Throwable?) {
                Log.e("ActionsRepositoryImpl", "Problem calling API ${t?.message}")
              }

              override fun onResponse(call: Call<Actions>?, response: Response<Actions>?) {
                response?.isSuccessful.let {
                  resultList = response?.body()
                }
              }
            }

            client.getActionsInfo(actionsCallback)

            return resultList
          }
        *
        * */

        val action1 = Action("animation", true, 0, arrayOf(0,2), 80000.0)
        val action2 = Action("toast", true, 1, arrayOf(0,2), 10000.0)
        val action3 = Action("call", true, 2, arrayOf(0,2), 20000.0)
        val action4 = Action("notification", true, 3, arrayOf(0,2), 10000.0)

        return arrayOf(action1, action2, action3, action4)
    }
}