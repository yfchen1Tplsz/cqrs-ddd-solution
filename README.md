# cqrs-ddd-solution
性质：个人笔记
简述：该项目是个人基于cqrs思想指导下的充血模型ddd落地solution，将会作为代码示例指导后续的开发
作者： tplhk-yfchen1
说明： 该项目中将每个查询都封装为queryExecutor，并配置对应的queryParam，使用策略工厂模式生成queryExecutor，使用enum标识查询种类。至此query模块将不会依赖任何上层模块，抽离出来沉底，而command模块仍然走domain结构，对于create操作将走factory生成。
值得注意的是，该模型中将repository层下沉到infrastructure以及让infrastructure层实现domain的数据操作接口，这些操作都是为了让domain与infrastructure依赖倒置，后续数据操作的底层实现改变也不会影响domain核心业务。当然，本人刚刚开始接触，学疏才浅，对很多概念似懂非懂，有不同想法或者质疑还请多多提出。
