package com.cn.web.controller;

import com.cn.config.SystemConfig;
import com.cn.dto.JsonResult;
import com.cn.pojo.Post;
import com.cn.pojo.PostImg;
import com.cn.service.PostImgService;
import com.cn.service.PostSerivce;
import com.cn.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RestController
@Api(tags = "尤翔龙",value = "帖子API")
public class PostController {
    @Autowired
    private PostImgService postImgService;
    @Autowired
    private SystemConfig sysc;
    @Autowired
    private PostSerivce postSerivce;
    /**
     * 发表帖子
     * @param post
     * @return
     */
    @PostMapping("/post/addPost")
    @ApiOperation(tags = "罗世杰",value = "发表帖子")
    @ApiImplicitParam(paramType = "body",name = "post",value = "帖子对象",required = true,dataType = "Post")
    public JsonResult addPost(@RequestBody Post post){
        return postSerivce.addPost(post);
    }

    /**
     * @from:罗世杰
     * 文件上传并返回ID及路径
     * @param multiRequest
     * @return
     * @throws IOException
     */
    @PostMapping("/file/insert")
    public JsonResult upload(MultipartHttpServletRequest multiRequest) throws IOException{
        List<PostImg> postImgs = new ArrayList<>();
        //获取所有文件名
        Iterator<String> fileNames=multiRequest.getFileNames();

        //便利为单个文价处理
        while (fileNames.hasNext()){
            //得到表单的name属性值
            String fileNameFrom=fileNames.next();
            //得到file对象
            MultipartFile file=multiRequest.getFile(fileNameFrom);


            // 获取文件的名字
            String filename = file.getOriginalFilename();
            // 解析文件的后缀
            String suffix = FileUtil.getSuffix(filename);
            if(suffix==null){
                return new JsonResult(4003,"文件名不符合规范!");
            }
            // 判断后缀是否符合需求
            String suffixs = sysc.getSuffixs();
            if(!suffixs.contains(suffix)){
                return new JsonResult(4004,"文件类型不符合要求!");
            }

            // 获取唯一的文件名
            String uploadFileName = FileUtil.getFileName();

            // 获取文件保存的路径
            String datePath = FileUtil.getDataFilePath();

            // 获取文件保存的路径
            String basePath = sysc.getBasePath();

            // 先创建上传的路径
            FileUtil.createDirs(basePath+"post/"+datePath);

            //文件路径加名字
            String fileName="post/"+datePath + uploadFileName + suffix;
            System.out.println(fileName);
            // 准备文件抽象的File对象
            File filenew = new File(basePath +"post/"+ datePath + uploadFileName + suffix);
            // 上传
            file.transferTo(filenew);

            //将文件路径保存到数据库
            if (!postImgService.addPostImg(fileName)) {
                return new JsonResult(422,"上传失败");
            }
            //查询出保存的对象数据然后保存在List中
            PostImg postImg=postImgService.findAll(fileName);
            System.out.println(postImg.getPostUrl()+66666);
            postImgs.add(postImg);
        }
        return new JsonResult(200,"上传成功",postImgs);
    }

    /**
     * 删除帖子（软删）
     * @param postId 需要删除的帖子ID
     * @return
     */
    @PostMapping("/post/del")
    @ApiOperation(tags = "尤翔龙",value = "删除帖子")
    @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
    public JsonResult deletePost(@RequestParam(value = "postId") Integer postId){
        return postSerivce.deleteByPostId(postId);
    }

    /**
     * 修改帖子
     * @param post
     * @return
     */
    @PostMapping("/post/put")
    @ApiOperation(tags = "尤翔龙",value = "修改帖子")
    @ApiImplicitParam(paramType = "body",name = "post",value = "帖子对象",required = true,dataType = "Post")
    public JsonResult updatePost(@RequestBody Post post){
        return postSerivce.updatePost(post);
    }

    /**
     * 通过ID查询帖子详情
     * @param postId 帖子ID
     * @return
     */
    @GetMapping("/post/getPost")
    @ApiOperation(tags = "尤翔龙",value = "查看帖子详情")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int"),
        @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int")
    })
    public JsonResult findByPostId(@RequestParam(value = "postId") Integer postId,@RequestParam(value = "userId") Integer userId){
        return postSerivce.findByPostId(postId,userId);
    }

    /**
     * 查询所有帖子（热门推荐）
     * @param userId
     * @return
     */
    @GetMapping("/post/list")
    @ApiOperation(tags = "尤翔龙",value = "查询所有帖子（热门推荐）")
    @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int")
    public JsonResult findAllPost(Integer userId){
        return postSerivce.findAllPost(userId);
    }

    /**
     * 收藏帖子
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return
     */
    @PostMapping("/post/col")
    @ApiOperation(tags = "尤翔龙",value = "收藏帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
    })
    public JsonResult collectPost(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "postId") Integer postId){
        return postSerivce.collectPost(userId,postId);
    }

    /**
     * 取消收藏帖子
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return
     */
    @DeleteMapping("/post/notCol")
    @ApiOperation(tags = "尤翔龙",value = "取消收藏帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
    })
    public JsonResult notCollectPost(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "postId") Integer postId){
        return postSerivce.notCollectPost(userId,postId);
    }

//    /**
//     * 判断是否已收藏
//     * @param userId
//     * @param postId
//     * @return
//     */
//    @GetMapping("/post/isCol")
//    @ApiOperation(tags = "尤翔龙",value = "判断是否收藏")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
//            @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
//    })
//    public JsonResult isCollectPost(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "postId") Integer postId){
//        return postSerivce.isCollectPost(userId,postId);
//    }

    /**
     * 给帖子点赞
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return
     */
    @PostMapping("/post/like")
    @ApiOperation(tags = "尤翔龙",value = "给帖子点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
    })
    public JsonResult giveLikePost(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "postId") Integer postId){
        return postSerivce.giveLikePost(userId,postId);
    }

    /**
     * 取消帖子点赞
     * @param userId 用户ID
     * @param postId 帖子ID
     * @return
     */
    @DeleteMapping("/post/notLike")
    @ApiOperation(tags = "尤翔龙",value = "取消帖子点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
    })
    public JsonResult notLikePost(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "postId") Integer postId){
        return postSerivce.notLikePost(userId,postId);
    }

//    /**
//     * 判断是否已点赞
//     * @param userId
//     * @param postId
//     * @return
//     */
//    @GetMapping("/post/isLike")
//    @ApiOperation(tags = "尤翔龙",value = "判断帖子是否已点赞")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
//            @ApiImplicitParam(paramType = "query",name = "postId",value = "帖子ID",required = true,dataType = "int")
//    })
//    public JsonResult isLikePost(@RequestParam(value = "userId") Integer userId,@RequestParam(value = "postId") Integer postId){
//        return postSerivce.isLikePost(userId,postId);
//    }

    /**
     * 通过用户ID查询关注用户所有帖子
     * @param userId
     * @return
     */
    @GetMapping("/post/fol")
    @ApiOperation(tags = "尤翔龙",value = "通过用户ID查询关注用户所有帖子")
    @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int")
    public JsonResult findFollowUserPost(@RequestParam(value = "userId") Integer userId){
        return postSerivce.findFollowUserPost(userId);
    }
    /**
     * 通过圈子ID查询所有帖子
     * @author 尤翔龙
     * @param circleId
     * @param userId
     * @return
     */
    @GetMapping("/post/cir")
    @ApiOperation(tags = "尤翔龙",value = "通过圈子ID查询圈子所有帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "userId",value = "用户ID",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name = "circleId",value = "圈子ID",required = true,dataType = "int")
    })
    public JsonResult findByCircleId(@RequestParam(value = "circleId") Integer circleId,@RequestParam(value = "userId") Integer userId){
        return postSerivce.findByCircleId(circleId,userId);
    }
}
