package com.cn.service;

import com.cn.dto.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lj
 * @date 2019/11/30 19:46
 */
public interface BannerService {
    //***************************************************陶仟

    /**
     * 查询顶部banner
     * @return
     */
    JsonResult BannerContent();

    ///////////////////////////////////////////////李静的代码！勿动！管理员管理Banner///////////////////////////////////////

    /**
     * 根据BannerType查找Banner
     * @param bannerType : Banner类型
     * @return ：Banner
     */
    public JsonResult findBannerByBannerType(Integer bannerType);

    /**
     * 根据Banner类型和BannerId查找具体的Banner
     *
     * @param bannerType ： Banner类型
     * @param bannerId   ： BannerId
     * @return
     */
    public JsonResult findBannerById(Integer bannerType, Integer bannerId);

    /**
     * 添加问答Banner的内容
     * @param bannerType ：Banner类型
     * @param bannerName ： Banner名字
     * @param questionId ： 问答的Id
     * @param file ： Banner的图片
     * @return
     */
    public JsonResult addQuestionBanner(Integer bannerType, String bannerName, Integer questionId, MultipartFile file);

    /**
     * 添加主页Banner的内容
     * @param bannerType ：Banner类型
     * @param bannerName ： Banner名字
     * @param postId ： 问答的Id
     * @param file ： Banner的图片
     * @return
     */
    public JsonResult addUserBanner(Integer bannerType, String bannerName, Integer postId, MultipartFile file);

    /**
     * 添加圈子Banner的内容
     * @param bannerType ：Banner类型
     * @param bannerName ： Banner名字
     * @param file ： Banner的图片
     * @return
     */
    public JsonResult addCircleBanner(Integer bannerType, String bannerName, MultipartFile file);

    /**
     * 根据BannerId删除Banner
     * @param bannerId
     * @return
     */
    public JsonResult delBannerById(Integer bannerId);

    /**
     * 根据BannerId更改圈子Banner
     * @param bannerName
     * @param bannerId
     * @param file
     * @return
     */
    public JsonResult updateCircleBanner(String bannerName, Integer bannerId, MultipartFile file);

    /**
     * 根据BannerId更改社区Banner
     * @param bannerName
     * @param bannerId
     * @param postId
     * @param file
     * @return
     */
    public JsonResult updateUserBanner(String bannerName,Integer bannerId, Integer postId, MultipartFile file);

    /**
     * 根据BannerId更改问答Banner
     * @param bannerName
     * @param bannerId
     * @param questionId
     * @param file
     * @return
     */
    public JsonResult updateQuestionBanner(String bannerName,Integer bannerId, Integer questionId, MultipartFile file) ;
    ///////////////////////////////////////////////李静的代码！勿动！！////////////////////////////////////////////////////
}
