import java.util.Scanner

fun main() {
    val myService = MyService()
    while (true) {
        println("1-> qo`shish; 2-> korish; 3 -> tahrirlash; 4 -> o`chirish; 5->qidirish")
        when (Scanner(System.`in`).nextInt()) {
            1 -> myService.addUser()
            2 -> myService.showUser()
            3 -> myService.editUser()
            4 -> myService.deleteUser()
            5 -> myService.searchUser()
        }
    }
}

//vazifa 1












