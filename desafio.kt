enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
        println("Usuário(s) matriculado(s) na formação $nome:")
        usuarios.forEach { println(it.nome) }
    }
}

fun main() {
    // Conteudos
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", duracao = 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", duracao = 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android", duracao = 150)

    // Formação
    val formacaoAndroid = Formacao("Formação Android", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2, conteudo3))

    // Usuarios
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    // Matrícula
    formacaoAndroid.matricular(usuario1, usuario2)
}
