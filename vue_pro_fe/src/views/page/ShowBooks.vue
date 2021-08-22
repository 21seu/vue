<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
            >
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
            >
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
            >
            </el-table-column>
            <el-table-column
                    label="操作"
            >
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button type="text" size="small" @click="deleteBook(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                page-size="4"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            edit(row) {
                console.log(row.id);
                this.$router.push({
                    path: '/update',
                    query: {
                        id: row.id
                    }
                })
            },
            deleteBook(row) {
                const _this = this;
                axios.delete('http://localhost:8181/book/delete/' + row.id)
                    .then(function (response) {
                        _this.$alert("删除成功", '提示', {
                            confirmButtonText: '确定',
                            callback: action => {
                                //_this.$router.push('/showBooks');
                                window.location.reload();
                            }
                        });
                    })
            },
            page(currPage) {
                const _this = this;
                axios.get('http://localhost:8181/book/findAll/' + currPage + '/4')
                    .then(function (response) {
                        console.log('currData====>', response)
                        _this.tableData = response.data.content;
                        _this.total = response.data.totalElements
                    })
            }
        },

        created() {
            const _this = this;
            axios.get('http://localhost:8181/book/findAll/1/4')
                .then(function (response) {
                    console.log(response)
                    _this.tableData = response.data.content;
                    _this.total = response.data.totalElements
                })
        },

        data() {
            return {
                total: null,
                tableData: [],
                ruleForm: {
                    id: '',
                    name: '',
                    author: ''
                }
            }
        }
    }
</script>