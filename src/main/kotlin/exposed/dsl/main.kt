package jp.ac.it_college.std.s24016.kotlin.exposed.dsl
//dslお試しコード
import org.jetbrains.exposed.v1.core.StdOutSqlLogger
import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.select
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main(){
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/exposed_example",
        driver = "org.postgresql.Driver",
        user = "exposed",
        password = "kotlin"
    )

    transaction {
        addLogger(StdOutSqlLogger)

        val userId = Member.insert {
            it[name] = "Kotlin"
        } get Member.id
        println("Inserted id: ${userId}")

        val user = Member.select(Member.columns)
            .where{Member.id eq userId}
            .single()
        println("id: ${user[Member.id]}")
        println("name: ${user[Member.name]}")
    }
}

object Member : Table("member") {
    val id = integer(name = "id").autoIncrement()
    val name = varchar("name", 32)
    override val primaryKey = PrimaryKey(id)
}