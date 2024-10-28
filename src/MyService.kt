import java.io.File
import java.util.Scanner

class MyService : MyServiceInterface{
    override fun addUser() {
        val list = readFile()
        println("Foydalanuvchi ismni kiriting: ")
        val name = Scanner(System.`in`).next()
        println("Foydalanuvchi telefon raqamini  kiriting: ")
        val phone = Scanner(System.`in`).next()
        val user= User(name,phone)
        list.add(user)
        writeFile(list)
    }

    override fun showUser() {
        val list = readFile()
        if (list.isNotEmpty()){
            for (user in list) {
                println(user)
            }
        }else{
            println("Royhat bo`sh")
        }
    }

    override fun editUser() {
        val list = readFile()
        println("Qaysi birini tahrirlaymiz: ")
        for (i in  list.indices){
            println("$i -> ${list[i]}")
        }
        val index = Scanner(System.`in`).nextInt()
        println("Yangi ism kiriting: ")
        val newName = Scanner(System.`in`).next()
        println("Yangi telefon raqam  kiriting: ")
        val newPhone = Scanner(System.`in`).next()
        list[index].name = newName
        list[index].phone = newPhone
        writeFile(list)
        println("Tahrirlandi")
    }

    override fun deleteUser() {
        val list = readFile()
        println("Qaysi foydalanuvchi o`chirilsin")
        for (i in list.indices) {
            println("$i ->${list[i]}")
        }
        val index = Scanner(System.`in`).nextInt()
        list.removeAt(index)
     writeFile(list)
        println("O`chirildi")
    }

    override fun searchUser() {
        val list = readFile()
        println("Qidirilmoqchi bolgan foygalanuvchi nomini kiriting: ")
        val searchName = Scanner(System.`in`).next()
        for (user in list) {
            if (user.name.lowercase().contains(searchName.lowercase())){
                println(user)
            }
        }
    }

    val file = File("Registratsiya.txt")
    override fun readFile(): ArrayList<User> {
        val list = ArrayList<User>()
       if (file.isFile){
           val a = file.readLines()

           for (s in a) {
               val user = User(
                   s.substring(0, s.indexOf('#')),
                   s.substring(s.indexOf('#')+1, s.indexOf('?')),

               )
               list.add(user)
           }

       }
        return  list
    }

    override fun writeFile(list: ArrayList<User>) {
        if (file.isFile){
            file.createNewFile()
        }


        }

    }

