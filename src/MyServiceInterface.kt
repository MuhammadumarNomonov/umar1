interface MyServiceInterface {
    fun addUser()
   fun showUser ()
    fun editUser()
    fun deleteUser()
    fun  searchUser()

    fun  readFile():ArrayList<User>
    fun writeFile(list: ArrayList<User>)
}