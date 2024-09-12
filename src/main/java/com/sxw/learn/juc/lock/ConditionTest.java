package com.sxw.learn.juc.lock;

import com.google.common.collect.Sets;
import lombok.SneakyThrows;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过使用 Condition，可以实现多个线程在不同条件下的等待和唤醒，从而更灵活地控制线程之间的协作，避免了使用 synchronized 结合 wait() 和 notify()/notifyAll() 方法只能实现单路通知的局限性。
 */
public class ConditionTest {
    private Integer MAX = 5;

    private ReentrantLock lock = new ReentrantLock();

    // 期望队列不为空
    private Condition notEmpty = lock.newCondition();

    // 期望队列未满
    private Condition notFull = lock.newCondition();

    private Queue<String> container = new LinkedBlockingQueue(50);

    public void produce(){
        lock.lock();
        try {
            if (container.size() >= MAX){
                notFull.await();
            }
            container.offer("ikun");
            System.out.println("生产元素-> ikun" + container.size());

            notEmpty.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try {
            if (container.isEmpty()){
                notEmpty.await();
            }
            container.poll();
            System.out.println("消费元素-> ikun" + container.size());

            notFull.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
//        ConditionTest conditionTest = new ConditionTest();
//        Thread produce = new Thread(() -> {
//            while (true){
//                conditionTest.produce();
//            }
//        });
//        Thread consumer = new Thread(() -> {
//            while (true){
//                conditionTest.consumer();
//            }
//        });
//
//        consumer.start();
//        produce.start();

        Set<String> zTables = Sets.newHashSet();
        zTables.add("dim_admin_department_child");
        zTables.add("dim_clue_user_itm");
        zTables.add("dim_daibo_user_itm");
        zTables.add("dim_jd_goods_itm");
        zTables.add("dim_kol_user_itm");
        zTables.add("dim_outside_task_channel_itm");
        zTables.add("dim_store_itm");
        zTables.add("dim_tb_goods_itm");
        zTables.add("dwd_clue_order_detail_di");
        zTables.add("dwd_daibo_cust_df");
        zTables.add("dwd_daibo_live_sessions_di");
        zTables.add("dwd_douyin_order_di");
        zTables.add("dwd_jl_live_realtime_di");
        zTables.add("dwd_jl_luopan_goods_di");
        zTables.add("dwd_jl_luopan_kol_data_di");
        zTables.add("dwd_jl_luopan_kol_fan_data_di");
        zTables.add("dwd_jl_luopan_kol_live_data_detail_di");
        zTables.add("dwd_jl_luopan_kol_rel_data_di");
        zTables.add("dwd_jl_luopan_live_channel_analysis_di");
        zTables.add("dwd_jl_luopan_store_revenue_di");
        zTables.add("dwd_jl_qianchuan_common_promotion_di");
        zTables.add("dwd_jl_qianchuan_live_cost_di");
        zTables.add("dwd_jl_qianchuan_live_funnel_di");
        zTables.add("dwd_kol_alliance_douyin_orders_di");
        zTables.add("dwd_merchant_settlement_order");
        zTables.add("dwd_non_cp_item_detail_di");
        zTables.add("dwd_non_cp_pay_di");
        zTables.add("dwd_offsite_data_statistic_di");
        zTables.add("dwd_order_detail_di");
        zTables.add("dwd_outside_coupon_di");
        zTables.add("dwd_outside_invest_proposal_task_di");
        zTables.add("dwd_qianchuan_stats_di");
        zTables.add("dwd_shence_log_detail_di");
        zTables.add("dwd_sub_opr_order_detail_di");
        zTables.add("dwd_tkt_order_detail_di");
        zTables.add("dwd_tp_shop_df");
        zTables.add("ods_merchant_settlement_order");

        Set<String> dwTableSet = Sets.newHashSet();
        dwTableSet.add("dim_admin_department_child");
        dwTableSet.add("dim_admin_department_itm");
        dwTableSet.add("dim_admin_itm");
        dwTableSet.add("dim_admin_role_itm");
        dwTableSet.add("dim_bc_brand_factor_itm");
        dwTableSet.add("dim_bc_category_factor_itm");
        dwTableSet.add("dim_bc_platform_factor_itm");
        dwTableSet.add("dim_cloud_union_itm");
        dwTableSet.add("dim_cloud_user_itm");
        dwTableSet.add("dim_clue_admin_itm");
        dwTableSet.add("dim_clue_chat_room_itm");
        dwTableSet.add("dim_clue_user_itm");
        dwTableSet.add("dim_daibo_base_itm");
        dwTableSet.add("dim_daibo_cust_itm");
        dwTableSet.add("dim_daibo_host_itm");
        dwTableSet.add("dim_daibo_live_room_itm");
        dwTableSet.add("dim_daibo_project_itm");
        dwTableSet.add("dim_daibo_user_itm");
        dwTableSet.add("dim_date_itm");
        dwTableSet.add("dim_goods_itm");
        dwTableSet.add("dim_jd_goods_itm");
        dwTableSet.add("dim_jd_rid_itm");
        dwTableSet.add("dim_jl_yuntu_hot_content_kol_itm");
        dwTableSet.add("dim_kol_goods_itm");
        dwTableSet.add("dim_kol_user_itm");
        dwTableSet.add("dim_lm_tb_channel_itm");
        dwTableSet.add("dim_openmall_douyin_product_itm");
        dwTableSet.add("dim_origin_goods_category_itm");
        dwTableSet.add("dim_outside_task_channel_itm");
        dwTableSet.add("dim_pgy_content_tag_itm");
        dwTableSet.add("dim_platform_itm");
        dwTableSet.add("dim_smzdm_goods_category_itm");
        dwTableSet.add("dim_store_itm");
        dwTableSet.add("dim_store_type_itm");
        dwTableSet.add("dim_taoke_user_itm");
        dwTableSet.add("dim_target_set_itm");
        dwTableSet.add("dim_tb_goods_itm");
        dwTableSet.add("dim_tkt_user_itm");
        dwTableSet.add("dim_tp_shop_itm");
        dwTableSet.add("dim_user_itm");
        dwTableSet.add("dwd_ad_service_di");
        dwTableSet.add("dwd_admin_itm_df");
        dwTableSet.add("dwd_alliance_user_di");
        dwTableSet.add("dwd_brand_api_record_di");
        dwTableSet.add("dwd_brand_cat_map_di");
        dwTableSet.add("dwd_channel_clues_record_di");
        dwTableSet.add("dwd_cloud_jd_union_order_detail_di");
        dwTableSet.add("dwd_cloud_taobao_giftcash_set_di");
        dwTableSet.add("dwd_cloud_union_df");
        dwTableSet.add("dwd_cloud_user_df");
        dwTableSet.add("dwd_clue_clue_pool_di");
        dwTableSet.add("dwd_clue_goods_di");
        dwTableSet.add("dwd_clue_order_detail_di");
        dwTableSet.add("dwd_clue_resource_di");
        dwTableSet.add("dwd_clue_room_settings_di");
        dwTableSet.add("dwd_clue_send_plan_di");
        dwTableSet.add("dwd_cp_activity_goods_di");
        dwTableSet.add("dwd_daibo_cust_df");
        dwTableSet.add("dwd_daibo_kpi_operator_config_di");
        dwTableSet.add("dwd_daibo_live_sessions_di");
        dwTableSet.add("dwd_daibo_product_di");
        dwTableSet.add("dwd_daibo_schedule_sessions_di");
        dwTableSet.add("dwd_daibo_user_monthly_target_di");
        dwTableSet.add("dwd_douyin_operating_aftersale_di");
        dwTableSet.add("dwd_douyin_order_di");
        dwTableSet.add("dwd_douyin_order_di_tmp");
        dwTableSet.add("dwd_douyin_settlement_order_di");
        dwTableSet.add("dwd_gjr_order_low_price");
        dwTableSet.add("dwd_gjr_order_low_price_temp");
        dwTableSet.add("dwd_goods_submit_di");
        dwTableSet.add("dwd_jl_live_realtime_di");
        dwTableSet.add("dwd_jl_luopan_goods_di");
        dwTableSet.add("dwd_jl_luopan_kol_data_di");
        dwTableSet.add("dwd_jl_luopan_kol_fan_data_di");
        dwTableSet.add("dwd_jl_luopan_kol_live_data_detail_di");
        dwTableSet.add("dwd_jl_luopan_kol_rel_data_di");
        dwTableSet.add("dwd_jl_luopan_live_channel_analysis_di");
        dwTableSet.add("dwd_jl_luopan_store_revenue_di");
        dwTableSet.add("dwd_jl_qianchuan_common_promotion_di");
        dwTableSet.add("dwd_jl_qianchuan_live_cost_di");
        dwTableSet.add("dwd_jl_qianchuan_live_funnel_di");
        dwTableSet.add("dwd_jl_yuntu_hot_content_di");
        dwTableSet.add("dwd_jl_yuntu_hot_content_kol_di");
        dwTableSet.add("dwd_jl_yuntu_hot_content_kol_video_di");
        dwTableSet.add("dwd_jl_yuntu_talent_mkting_cooperation_di");
        dwTableSet.add("dwd_kol_alliance_douyin_orders_di");
        dwTableSet.add("dwd_kol_deal_di");
        dwTableSet.add("dwd_kol_deal_itm_df");
        dwTableSet.add("dwd_kol_user_itm_df");
        dwTableSet.add("dwd_lm_tb_goods_effect_calendar");
        dwTableSet.add("dwd_lm_tb_shop_effect_calendar");
        dwTableSet.add("dwd_merchant_settlement_order");
        dwTableSet.add("dwd_non_cp_income_detail_di");
        dwTableSet.add("dwd_non_cp_item_detail_di");
        dwTableSet.add("dwd_non_cp_pay_detail_di");
        dwTableSet.add("dwd_non_cp_pay_di");
        dwTableSet.add("dwd_offsite_article_pub_di");
        dwTableSet.add("dwd_offsite_data_statistic_di");
        dwTableSet.add("dwd_order_detail_di");
        dwTableSet.add("dwd_order_detail_di_bak");
        dwTableSet.add("dwd_order_taobao_channel_union_di");
        dwTableSet.add("dwd_outside_coupon_di");
        dwTableSet.add("dwd_outside_invest_proposal_di");
        dwTableSet.add("dwd_outside_invest_proposal_task_df");
        dwTableSet.add("dwd_outside_invest_proposal_task_di");
        dwTableSet.add("dwd_pgy_content_kol_base_di");
        dwTableSet.add("dwd_pgy_content_kol_notes_di");
        dwTableSet.add("dwd_qianchuan_stats_di");
        dwTableSet.add("dwd_right_protection_order_di");
        dwTableSet.add("dwd_settlement_order_detail_di");
        dwTableSet.add("dwd_settlement_order_detail_di_0701");
        dwTableSet.add("dwd_settlement_order_detail_di_bak");
        dwTableSet.add("dwd_shence_log_detail_di");
        dwTableSet.add("dwd_star_task_di");
        dwTableSet.add("dwd_store_group_period_statistics_di");
        dwTableSet.add("dwd_store_his");
        dwTableSet.add("dwd_store_itm_dd");
        dwTableSet.add("dwd_sub_opr_order_detail_di");
        dwTableSet.add("dwd_taobao_channel_union_goods_di");
        dwTableSet.add("dwd_taoke_order_detail_di");
        dwTableSet.add("dwd_tkt_channel_detail_di");
        dwTableSet.add("dwd_tkt_coop_form_di");
        dwTableSet.add("dwd_tkt_cp_jd_union_order_detail_di");
        dwTableSet.add("dwd_tkt_head_detail_di");
        dwTableSet.add("dwd_tkt_jd_union_order_detail_di");
        dwTableSet.add("dwd_tkt_jxtt_order_detail_di");
        dwTableSet.add("dwd_tkt_order_detail_202305");
        dwTableSet.add("dwd_tkt_order_detail_202306");
        dwTableSet.add("dwd_tkt_order_detail_di");
        dwTableSet.add("dwd_tkt_order_detail_f");
        dwTableSet.add("dwd_tkt_rid_union_order_detail_di");
        dwTableSet.add("dwd_tkt_toolmaker_detail_di");
        dwTableSet.add("dwd_tkt_top_sale_goods_di");
        dwTableSet.add("dwd_tkt_top_sale_goods_di_202305");
        dwTableSet.add("dwd_tkt_top_sale_goods_di_202306");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_di");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_di_202305");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_di_202305_01");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_di_202305_bak");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_di_202306");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_record");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_record_202305");
        dwTableSet.add("dwd_tkt_top_sale_goods_shop_record_202306");
        dwTableSet.add("dwd_tkt_top_sale_goods_tz_gmv_di");
        dwTableSet.add("dwd_tkt_top_sale_goods_tz_gmv_di_202305");
        dwTableSet.add("dwd_tkt_top_sale_goods_tz_gmv_di_202306");
        dwTableSet.add("dwd_tkt_top_sale_shops_di");
        dwTableSet.add("dwd_tkt_top_sale_shops_di_202305");
        dwTableSet.add("dwd_tkt_top_sale_shops_di_202306");
        dwTableSet.add("dwd_tp_shop_df");
        dwTableSet.add("dwd_user_login_log_di");
        dwTableSet.add("dwd_xy_goods_df");
        dwTableSet.add("dwd_xy_goods_di");
        dwTableSet.add("dwd_zdm_commission_rate_di");
        dwTableSet.add("dws_clue_pool_cp_data_di");
        dwTableSet.add("dws_gjr_order_detail_di");
        dwTableSet.add("dws_head_promote_date_di");
        dwTableSet.add("dws_order_detail_di");
        dwTableSet.add("note_topic_words_map");
        dwTableSet.add("note_topic_words_map_bak");
        dwTableSet.add("ods_merchant_settlement_order");
        dwTableSet.add("ods_shence_log");
        dwTableSet.add("ods_tkt_order_channel");
        dwTableSet.add("ods_tkt_order_head");
        dwTableSet.add("ods_tkt_order_toolmaker");
        dwTableSet.add("realtime_dwd_order_detail_base");
        dwTableSet.add("realtime_dws_order_detail_hi");

        dwTableSet.removeAll(zTables);

        System.out.println(dwTableSet.size());
        dwTableSet.stream().forEach(System.out::println);

    }
}
