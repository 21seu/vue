<template>
    <div>
        <table>
            <tr v-for="b in books">
                <td v-text="b.id">编号</td>
                <td v-text="b.name">图书名称</td>
                <td v-text="b.author">作者</td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "Book",
        data() {
            return {
                meg: 'Hello Vue',
                books: [{
                    id: 1,
                    name: 'Java',
                    author: 'zhangsan'
                }, {
                    id: 2,
                    name: 'JavaScript',
                    author: 'lisi'
                }]
            }
        },

        created() {
            const _this = this;
            axios.get('http://localhost:8181/book/findAll')
                .then(function (response) {
                    console.log(response);
                    _this.books = response.data;
                })
        }
    }
</script>

<style scoped>

</style>