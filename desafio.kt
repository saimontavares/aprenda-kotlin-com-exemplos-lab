enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, val nivel: Nivel, val conteudosEducacionais: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(vararg alunos: Aluno) {
        inscritos.addAll(alunos)
    }

    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }

    fun duracaoTotal(): Int {
        return conteudosEducacionais.sumOf { it.duracao }
    }
}

fun main() {
    // Simulação de cenários de teste:
    val aluno1 = Aluno("João Silva", "joao@email.com")
    val aluno2 = Aluno("Maria Santos", "maria@email.com")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 45, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90, Nivel.INTERMEDIARIO)

    val formacao = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    formacao.matricular(aluno1, aluno2)

    println("Formação: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    println("Conteúdos Educacionais: ${formacao.conteudosEducacionais.map { "${it.nome} (${it.nivel}, ${it.duracao}min)" }}")
    println("Duração Total: ${formacao.duracaoTotal()} minutos")
    println("Inscritos: ${formacao.inscritos.size} alunos")
    formacao.inscritos.forEach { println("- ${it.nome} (${it.email})") }
}