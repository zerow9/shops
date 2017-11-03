// 路径配置
require.config({
    paths: {
        echarts: 'http://echarts.baidu.com/build/dist'
    }
});

// 使用
require(
    [
        'echarts',
        'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
    ],
    function (ec) {
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('show_right'));

        var option = {
            backgroundColor: '#F3F3F4',
            title : {
                text: '同类商品对比折线图',
            },
            legend: {
                data:['商品1','商品2']
            },
            calculable : true,
            xAxis : [
                {
                    type: 'value'
                }
            ],
            yAxis : [
                {
                    type: 'value',
                    axisLine: {
                        lineStyle: {
                            color: '#dc143c'
                        }
                    }
                }
            ],
            series : [
                {
                    name:'商品1',
                    type:'line',
                    data:[
                        [1.5, 10], [5, 7], [8, 8], [12, 6], [11, 12], [16, 9], [14, 6], [17, 4], [19, 9]
                    ],
                    markPoint : {
                        data : [
                            // 纵轴，默认
                            {type : 'max', name: '最大值',symbol: 'emptyCircle', itemStyle:{normal:{color:'#dc143c',label:{position:'top'}}}},
                            {type : 'min', name: '最小值',symbol: 'emptyCircle', itemStyle:{normal:{color:'#dc143c',label:{position:'bottom'}}}},
                            // 横轴
                            {type : 'max', name: '最大值', valueIndex: 0, symbol: 'emptyCircle', itemStyle:{normal:{color:'#1e90ff',label:{position:'right'}}}},
                            {type : 'min', name: '最小值', valueIndex: 0, symbol: 'emptyCircle', itemStyle:{normal:{color:'#1e90ff',label:{position:'left'}}}}
                        ]
                    },
                    markLine : {
                        data : [
                            // 纵轴，默认
                            {type : 'max', name: '最大值', itemStyle:{normal:{color:'#dc143c'}}},
                            {type : 'min', name: '最小值', itemStyle:{normal:{color:'#dc143c'}}},
                            {type : 'average', name : '平均值', itemStyle:{normal:{color:'#dc143c'}}},
                            // 横轴
                            {type : 'max', name: '最大值', valueIndex: 0, itemStyle:{normal:{color:'#1e90ff'}}},
                            {type : 'min', name: '最小值', valueIndex: 0, itemStyle:{normal:{color:'#1e90ff'}}},
                            {type : 'average', name : '平均值', valueIndex: 0, itemStyle:{normal:{color:'#1e90ff'}}}
                        ]
                    }
                },
                {
                    name:'商品2',
                    type:'line',
                    data:[
                        [1, 2], [2, 3], [4, 2], [7, 5], [11, 2], [18, 3]
                    ]
                }
            ]
        };

        // 为echarts对象加载数据
        myChart.setOption(option);
    }
);