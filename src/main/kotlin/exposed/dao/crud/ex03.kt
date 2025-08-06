package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//select：条件付き(名前)でデータを取得する(crudのr)
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberTable
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    createSessionFactory()

    transaction {
        val members = MemberEntity.find {
            MemberTable.name eq "Saburo"
        }.map(::MemberModel)

        members.forEach(::println)
    }
}