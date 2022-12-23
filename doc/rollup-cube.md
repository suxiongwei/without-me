```roomsql
select 
formatDateTime(order_time,'%Y-%m') as `月份`
,formatDateTime(order_time,'%Y-%m-%d') as `日期`
,pl.name as `商城`
,b.name as `类目`
,c.name as `部门`
,count(*) as `订单量`
,sum(a.predict_serve_rate/100) as `服务费`
from dwd_order_detail_di a
inner join dim_platform_itm pl on a.platform = pl.value
inner join dim_smzdm_goods_category_itm b on a.store_smgscyid = b.smgscyid
inner join dim_admin_department_itm c on a.andtid = c.andtid
where order_time >= '2022-06-01 00:00:00' and order_time <= '2022-06-05 23:59:59'
and if_valid = 1
group by 
`月份`
,`日期`
,pl.name 
,b.name
,c.name
with cube;


select 
formatDateTime(order_time,'%Y-%m') as `月份`
,formatDateTime(order_time,'%Y-%m-%d') as `日期`
,pl.name as `商城`
,b.name as `类目`
,c.name as `部门`
,count(*) as `订单量`
,sum(a.predict_serve_rate/100) as `服务费`
from dwd_order_detail_di a
inner join dim_platform_itm pl on a.platform = pl.value
inner join dim_smzdm_goods_category_itm b on a.store_smgscyid = b.smgscyid
inner join dim_admin_department_itm c on a.andtid = c.andtid
where order_time >= '2022-06-01 00:00:00' and order_time <= '2022-06-05 23:59:59'
and if_valid = 1
group by 
`月份`
,`日期`
,pl.name 
,b.name
,c.name
with rollup;
```