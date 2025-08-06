package jp.ac.it_college.std.s24016.kotlin.exposed.dao
//daoお試しコード
import org.jetbrains.exposed.v1.core.StdOutSqlLogger
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass
import org.jetbrains.exposed.v1.jdbc.Database
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

        val member = MemberEntity.new {
            name = "Kotlin dao"
        }

        MemberEntity.findById(member.id)?.let { m ->
            println("id: ${m.id}")
            println("name: ${m.name}")
        }
    }
}

object MemberTable : IntIdTable("member") {
    val name = varchar("name", 32)
}

class MemberEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MemberEntity>(MemberTable)

    var name by MemberTable.name
}