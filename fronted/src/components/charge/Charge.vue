<template>
  <el-container>
    <el-main>
      <el-form :inline="true" :model="lookup">
        <el-form-item label="患者病历号">
          <el-input label="请输入病历号" v-model="lookup.medicalHistoryId"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="lookExpense">查询</el-button>
        </el-form-item>
      </el-form>
      <el-table
        ref="multipleTable"
        :data="expense"
        tooltip-effect="dark"
        style="height: 400px"
      >
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名">
        </el-table-column>
        <el-table-column
          prop="medicalHistoryId"
          label="病历号">
        </el-table-column>
        <el-table-column
          prop="itemName"
          label="项目名称">
        </el-table-column>
        <el-table-column
          prop="price"
          label="单价">
        </el-table-column>
        <el-table-column
          prop="amount"
          label="数量">
        </el-table-column>
        <el-table-column
          prop="state"
          label="状态">
        </el-table-column>
      </el-table>
      <el-button type="primary" @click="finishCharge">收费结算</el-button>
      <el-dialog title="发票信息" :visible.sync="dialogFormVisible">
        <el-form :model="invoice">
          <el-row :gutter=20>
            <el-col :span=12>
              <el-form-item label="发票号（可修改）：">
                <el-input v-model="invoice.id"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span=12>
              <el-form-item label="病历号：">
                <el-input v-model="invoice.medicalHistoryId"></el-input>
              </el-form-item>
            </el-col>

          </el-row>
          <el-row :gutter=20>
            <el-col :span=12>
              <el-form-item label="患者姓名">
              <el-input v-model="invoice.name"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span=12>
              <el-form-item label="结算类型">
              <el-select v-model="invoice.paymentType" style="width: 100%" placeholder="请选择结算类别">
                <el-option label="自费" value="1"></el-option>
                <el-option label="医保" value="2"></el-option>
              </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter=20>
            <el-col :span=12>
              <el-form-item label="应收金额：">
              <el-input v-model="invoice.moneyWant"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span=12>
              <el-form-item label="实收金额：">
              <el-input v-model="invoice.moneyGet" @change="cac"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter=20>
            <el-col :span=12>
              <el-form-item label="找零金额：">
              <el-input v-model="invoice.moneyReturn"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span=12></el-col>
          </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
      </el-dialog>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: 'Charge',
        data() {
            return {
                dialogFormVisible: false,
                expense: [],
                invoice: {
                    id: '201909091234',
                    medicalHistoryId: '600609',
                    name: '白居易',
                    paymentType: '',
                    moneyWant: '605',
                    moneyGet: '',
                    moneyReturn: ''
                },
                lookup: {
                    medicalHistoryId: ''
                }
            }
        },
        methods: {
            cac(){
                this.invoice.moneyReturn='95'
            },
            finishCharge() {
                this.dialogFormVisible = true;
            },
            lookExpense() {
                this.loadExpense();
            },
            loadExpense() {
                var _this = this;
                var params = new URLSearchParams();
                params.append('medicalHistoryId', this.lookup.medicalHistoryId)
                this.$axios.post('/expense', params).then(resp => {
                    if (resp) {
                        _this.expense = resp.data;
                    }
                })
            }
        },
    }
</script>

<style scoped>

</style>
