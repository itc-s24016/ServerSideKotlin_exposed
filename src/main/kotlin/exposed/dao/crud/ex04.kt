package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//insert：名前を指定してデータを挿入する(crudのc)
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberTable
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    createSessionFactory()

    transaction {
        val member = MemberEntity.new {
            name = "Shiro"
        }.let(::MemberModel)

        println(member)
    }
}