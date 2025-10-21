<template>
	<div class="home-preview">




		<!-- 商品推荐 -->
		<div id="animate_recommendhuodongxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">活动信息推荐</span>
				<span class="recommend_subhead">{{'huodongxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div v-if="huodongxinxiRecommend.length" class="list list11 index-pv1">
				<div class="tab_view">
					<template v-for="(item,index) in recommendList11huodongxinxi">
						<div v-if="index < 6" class="tab" @click="recommendIndexClick11(item,'huodongxinxi')">
							<span class="icon iconfont "></span>
							<img v-if="item.image" :src="baseUrl + (item.image?item.image.split(',')[0]:'')">
							<span class="text">{{item[recommendColumn11huodongxinxi]}}</span>
						</div>
					</template>
					<div class="more_btn" @click="moreBtn('huodongxinxi')">
						<span class="icon iconfont icon-jiantou34"></span>
						<div class="text">更多</div>
					</div>
				</div>
				<div class="list-body">
					<div class="item list-item animation-box" v-for="item,index in huodongxinxiRecommend" :key="index" @click="toDetail('huodongxinxiDetail', item)">
						<img :name="item.id" v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
						<img :name="item.id" v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
						<div class="name">{{item.huodongmingcheng}}</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('huodongxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 特价商品 -->
		<div id="animate_listhuodongxinxi" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">活动信息展示</span>
				<span class="list_subhead">{{'huodongxinxi'.toUpperCase()}} SHOW</span>
			</div>
			<div class="list list18 index-pv1">
				<div class="tab_view">
					<div class="tab" :class="listIndex18huodongxinxi == 0 ? 'tabActive' : ''" @click="listIndexClick18(0, 'huodongxinxi')">
						全部
					</div>
					<template v-for="(item,index) in listList18huodongxinxi">
						<div v-if="index < 6" class="tab" :class="listIndex18huodongxinxi == index + 1 ? 'tabActive' : ''" @click="listIndexClick18(index + 1, 'huodongxinxi')">
							{{item[listColumn18huodongxinxi]}}
						</div>
					</template>
				</div>
				<div class="list-body" v-if="huodongxinxiList.length">
					<div class="list-body-left">
						<div class="list-item1" @click="toDetail('huodongxinxiDetail', huodongxinxiList[0])">
							<div class="infoBox">
								<div class="name">{{huodongxinxiList[0].huodongmingcheng}}</div>
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{huodongxinxiList[0].addtime.split(' ')[0]}}</span>
								</div>
								<div class="publisher_item">
									<span class="icon iconfont icon-geren16"></span>
									<span class="label">发布人：</span>
									<span class="text">{{huodongxinxiList[0].jiaoshigonghao}}</span>
								</div>
								<div class="like_item">
									<span class="icon iconfont icon-zan10"></span>
									<span class="label">点赞：</span>
									<span class="text">{{huodongxinxiList[0].thumbsupnum}}</span>
								</div>
								<div class="collect_item">
									<span class="icon iconfont icon-shoucang10"></span>
									<span class="label">收藏：</span>
									<span class="text">{{huodongxinxiList[0].storeupnum}}</span>
								</div>
								<div class="view_item">
									<span class="icon iconfont icon-chakan2"></span>
									<span class="label">浏览次数：</span>
									<span class="text">{{huodongxinxiList[0].clicknum}}</span>
								</div>
							</div>
							<div class="img">
								<img v-if="preHttp(huodongxinxiList[0].fengmian)" :src="huodongxinxiList[0].fengmian.split(',')[0]" alt="" />
								<img v-else :src="baseUrl + (huodongxinxiList[0].fengmian?huodongxinxiList[0].fengmian.split(',')[0]:'')" alt="" />
							</div>
						</div>
						<div class="list-item2" @click="toDetail('huodongxinxiDetail', huodongxinxiList[1])">
							<div class="img">
								<img v-if="preHttp(huodongxinxiList[1].fengmian)" :src="huodongxinxiList[1].fengmian.split(',')[0]" alt="" />
								<img v-else :src="baseUrl + (huodongxinxiList[1].fengmian?huodongxinxiList[1].fengmian.split(',')[0]:'')" alt="" />
							</div>
							<div class="infoBox">
								<div class="name">{{huodongxinxiList[1].huodongmingcheng}}</div>
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{huodongxinxiList[1].addtime.split(' ')[0]}}</span>
								</div>
								<div class="publisher_item">
									<span class="icon iconfont icon-geren16"></span>
									<span class="label">发布人：</span>
									<span class="text">{{huodongxinxiList[1].jiaoshigonghao}}</span>
								</div>
								<div class="like_item">
									<span class="icon iconfont icon-zan10"></span>
									<span class="label">点赞：</span>
									<span class="text">{{huodongxinxiList[1].thumbsupnum}}</span>
								</div>
								<div class="collect_item">
									<span class="icon iconfont icon-shoucang10"></span>
									<span class="label">收藏：</span>
									<span class="text">{{huodongxinxiList[1].storeupnum}}</span>
								</div>
								<div class="view_item">
									<span class="icon iconfont icon-chakan2"></span>
									<span class="label">浏览次数：</span>
									<span class="text">{{huodongxinxiList[1].clicknum}}</span>
								</div>
							</div>
						</div>
					</div>
					<div class="list-body-right">
						<div class="swiper-container listSwiper18 list-list-18huodongxinxi">
							<div class="swiper-wrapper">
								<div class="swiper-slide" v-for="(item,index) in huodongxinxiList" :key="index" v-if="index>2">
									<div class="list-item" @click="toDetail('huodongxinxiDetail', item)">
										<div class="img">
											<img v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
											<img v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
										</div>
										<div class="infoBox">
											<div class="name">{{item.huodongmingcheng}}</div>
											<div class="time_item">
												<span class="icon iconfont icon-shijian21"></span>
												<span class="label">发布时间：</span>
												<span class="text">{{item.addtime.split(' ')[0]}}</span>
											</div>
											<div class="publisher_item">
												<span class="icon iconfont icon-geren16"></span>
												<span class="label">发布人：</span>
												<span class="text">{{item.jiaoshigonghao}}</span>
											</div>
											<div class="like_item">
												<span class="icon iconfont icon-zan10"></span>
												<span class="label">点赞：</span>
												<span class="text">{{item.thumbsupnum}}</span>
											</div>
											<div class="collect_item">
												<span class="icon iconfont icon-shoucang10"></span>
												<span class="label">收藏：</span>
												<span class="text">{{item.storeupnum}}</span>
											</div>
											<div class="view_item">
												<span class="icon iconfont icon-chakan2"></span>
												<span class="label">浏览次数：</span>
												<span class="text">{{item.clicknum}}</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('huodongxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
		<!-- 特价商品 -->
		<div id="animate_listgonggaoxinxi" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">公告信息展示</span>
				<span class="list_subhead">{{'gonggaoxinxi'.toUpperCase()}} SHOW</span>
			</div>
			<div class="list list18 index-pv1">
				<div class="list-body" v-if="gonggaoxinxiList.length">
					<div class="list-body-left">
						<div class="list-item1" @click="toDetail('gonggaoxinxiDetail', gonggaoxinxiList[0])">
							<div class="infoBox">
								<div class="name">{{gonggaoxinxiList[0].zhuti}}</div>
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{gonggaoxinxiList[0].addtime.split(' ')[0]}}</span>
								</div>
								<div class="like_item">
									<span class="icon iconfont icon-zan10"></span>
									<span class="label">点赞：</span>
									<span class="text">{{gonggaoxinxiList[0].thumbsupnum}}</span>
								</div>
								<div class="collect_item">
									<span class="icon iconfont icon-shoucang10"></span>
									<span class="label">收藏：</span>
									<span class="text">{{gonggaoxinxiList[0].storeupnum}}</span>
								</div>
							</div>
							<div class="img">
								<img v-if="preHttp(gonggaoxinxiList[0].fengmian)" :src="gonggaoxinxiList[0].fengmian.split(',')[0]" alt="" />
								<img v-else :src="baseUrl + (gonggaoxinxiList[0].fengmian?gonggaoxinxiList[0].fengmian.split(',')[0]:'')" alt="" />
							</div>
						</div>
						<div class="list-item2" @click="toDetail('gonggaoxinxiDetail', gonggaoxinxiList[1])">
							<div class="img">
								<img v-if="preHttp(gonggaoxinxiList[1].fengmian)" :src="gonggaoxinxiList[1].fengmian.split(',')[0]" alt="" />
								<img v-else :src="baseUrl + (gonggaoxinxiList[1].fengmian?gonggaoxinxiList[1].fengmian.split(',')[0]:'')" alt="" />
							</div>
							<div class="infoBox">
								<div class="name">{{gonggaoxinxiList[1].zhuti}}</div>
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{gonggaoxinxiList[1].addtime.split(' ')[0]}}</span>
								</div>
								<div class="like_item">
									<span class="icon iconfont icon-zan10"></span>
									<span class="label">点赞：</span>
									<span class="text">{{gonggaoxinxiList[1].thumbsupnum}}</span>
								</div>
								<div class="collect_item">
									<span class="icon iconfont icon-shoucang10"></span>
									<span class="label">收藏：</span>
									<span class="text">{{gonggaoxinxiList[1].storeupnum}}</span>
								</div>
							</div>
						</div>
					</div>
					<div class="list-body-right">
						<div class="swiper-container listSwiper18 list-list-18gonggaoxinxi">
							<div class="swiper-wrapper">
								<div class="swiper-slide" v-for="(item,index) in gonggaoxinxiList" :key="index" v-if="index>2">
									<div class="list-item" @click="toDetail('gonggaoxinxiDetail', item)">
										<div class="img">
											<img v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
											<img v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
										</div>
										<div class="infoBox">
											<div class="name">{{item.zhuti}}</div>
											<div class="time_item">
												<span class="icon iconfont icon-shijian21"></span>
												<span class="label">发布时间：</span>
												<span class="text">{{item.addtime.split(' ')[0]}}</span>
											</div>
											<div class="like_item">
												<span class="icon iconfont icon-zan10"></span>
												<span class="label">点赞：</span>
												<span class="text">{{item.thumbsupnum}}</span>
											</div>
											<div class="collect_item">
												<span class="icon iconfont icon-shoucang10"></span>
												<span class="label">收藏：</span>
												<span class="text">{{item.storeupnum}}</span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('gonggaoxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				huodongxinxiRecommend: [],

				huodongxinxiList: [],
				gonggaoxinxiList: [],


				recommendIndex11huodongxinxi: '',
				recommendList11huodongxinxi: [],
				recommendColumn11huodongxinxi: '',

				listListSwiper18huodongxinxi: null,
				listIndex18huodongxinxi: 0,
				listList18huodongxinxi: [],
				listColumn18huodongxinxi: '',
				listListSwiper18gonggaoxinxi: null,

			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getList();
			this.huodongxinxiRecommendCate()
			this.huodongxinxiListCate()
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				if (this['listListSwiper18huodongxinxi']) this['listListSwiper18huodongxinxi'].destroy()
				if (this['listListSwiper18gonggaoxinxi']) this['listListSwiper18gonggaoxinxi'].destroy()
				setTimeout(()=>{
					this['listListSwiper18huodongxinxi'] = new Swiper(".list-list-18huodongxinxi", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"pagination":{"el":".swiper-pagination","clickable":true},"loop":true,"coverflowEffect":{"rotate":10,"stretch":10,"depth":60,"modifier":3,"slideShadows":false},"centeredSlides":true,"slidesPerView":1,"spaceBetween":0,"autoplay":{"delay":3000,"disableOnInteraction":false}})
					this['listListSwiper18gonggaoxinxi'] = new Swiper(".list-list-18gonggaoxinxi", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"pagination":{"el":".swiper-pagination","clickable":true},"loop":true,"coverflowEffect":{"rotate":10,"stretch":10,"depth":60,"modifier":3,"slideShadows":false},"centeredSlides":true,"slidesPerView":1,"spaceBetween":0,"autoplay":{"delay":3000,"disableOnInteraction":false}})
				},750)
			},
			huodongxinxiRecommendCate(){
				this.$http.get('huodongfenlei/list',{
					params: {
						limit: Number(6)
					}
				}).then(res => {
					if (res.data.code == 0) {
						this.recommendList11huodongxinxi = res.data.data.list
					}
				});
				this.recommendColumn11huodongxinxi = 'huodongfenlei'
			},
			recommendIndexClick11(index, name) {
				this['recommendIndex11' + name] = index[this['recommendColumn11' + name]]
				this.getList()
			},

			huodongxinxiListCate(){
				this.$http.get('huodongfenlei/list',{
					params: {
						limit: Number(6)
					}
				}).then(res => {
					if (res.data.code == 0) {
						this.listList18huodongxinxi = res.data.data.list
					}
				});
				this.listColumn18huodongxinxi = 'huodongfenlei'
			},
			listIndexClick18(index, name) {
				this['listIndex18' + name] = index[this['listColumn18' + name]]
				this.getList()
			},

			handleScroll() {
				let arr = [
					{id:'about',css:'animate__fadeInRightBig'},
					{id:'system',css:'animate__slideInUp'},
					{id:'animate_recommendhuodongxinxi',css:'animate__zoomIn'},
					{id:'animate_listhuodongxinxi',css:'animate__bounceInLeft'},
					{id:'animate_listgonggaoxinxi',css:'animate__bounceInLeft'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "huodongxinxi/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "huodongxinxi/autoSort2";
				}
				data = {
					page: 1,
					limit: 8,
				}
				if(this.recommendIndex11huodongxinxi){
					data.huodongfenlei = this.recommendIndex11huodongxinxi
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.huodongxinxiRecommend = res.data.data.list;
					}
				});
			
				data = {
					page: 1,
					limit: 5,
				}

				if(this.listIndex18huodongxinxi != 0){
					data.huodongfenlei = this.listList18huodongxinxi[this.listIndex18huodongxinxi - 1].huodongfenlei
				}
				this.$http.get('huodongxinxi/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.huodongxinxiList = res.data.data.list;
					}
				});
				data = {
					page: 1,
					limit: 5,
				}

				this.$http.get('gonggaoxinxi/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.gonggaoxinxiList = res.data.data.list;
					}
				});
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		.recommend {
			padding: 0 0 10px;
			margin: 0px auto;
			background: none;
			width: 100%;
			position: relative;
			text-align: center;
			order: 1;
			.recommend_title_box {
				padding: 0;
				margin: 0 auto;
				background: url(http://codegen.caihongy.cn/20250423/45933adff10449008a6f3847926503fd.png) no-repeat center bottom;
				width: 1300px;
				position: relative;
				text-align: center;
				height: 60px;
				.recommend_title {
					margin: 0 auto;
					color: rgb(0, 78, 162);
					background: none;
					font-weight: 600;
					display: block;
					letter-spacing: 1px;
					width: auto;
					font-size: 32px;
					line-height: 60px;
					text-align: center;
				}
				.recommend_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: 100%;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list11 {
				padding: 0;
				margin: 0 auto;
				background: #fff;
				display: block;
				width: 1300px;
				justify-content: space-between;
				height: auto;
				.tab_view {
					margin: 30px 0 0 0;
					background: rgb(244, 244, 244);
					display: flex;
					width: 100%;
					height: auto;
					.tab {
						cursor: pointer;
						padding: 20px 0;
						margin: 0;
						width: 100%;
						border-color: #efefef;
						border-width: 0 0 1px 0;
						border-style: solid;
						height: auto;
						.icon {
							margin: 0 5px 0 0;
							color: #333;
							font-size: 16px;
							line-height: 44px;
						}
						img {
							margin: 0 5px 0 0;
							object-fit: cover;
							display: inline-block;
							width: 44px;
							height: 44px;
						}
						.text {
							color: rgb(0, 78, 162);
							font-size: 16px;
							line-height: 44px;
						}
					}
					.more_btn {
						cursor: pointer;
						padding: 10px 20px;
						margin: 0;
						display: none;
						width: 100%;
						border-color: #efefef;
						border-width: 0 0 1px 0;
						border-style: solid;
						height: auto;
						.icon {
							margin: 0 5px 0 0;
							color: #333;
							font-size: 16px;
							line-height: 44px;
						}
						.text {
							color: #333;
							font-size: 16px;
							line-height: 44px;
						}
					}
				}
				.list-body {
					margin: 50px 0 0;
					background: #fff;
					flex: 1;
					display: flex;
					gap: 20px;
					width: auto;
					flex-wrap: wrap;
					height: auto;
					.list-item {
						cursor: pointer;
						background: rgb(244, 244, 244);
						width: 420px;
						position: relative;
						height: auto;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							height: 200px;
						}
						.name {
							padding: 0 20px;
							overflow: hidden;
							color: #333;
							white-space: nowrap;
							width: 100%;
							font-size: 16px;
							line-height: 30px;
							text-overflow: ellipsis;
							text-align: left;
						}
						.price {
							padding: 0 20px;
							color: #f00;
							width: 100%;
							font-size: 16px;
							line-height: 2.5;
							text-align: left;
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 30px auto;
				background: rgb(0, 78, 162);
				display: inline-block;
				width: 250px;
				line-height: 48px;
				text-align: center;
				.text {
					color: #fff;
					font-size: 16px;
				}
				.icon {
					color: #fff;
					display: none;
					font-size: 15px;
				}
			}
		}
		.lists {
			padding: 0;
			margin: 30px 0;
			background: url(http://codegen.caihongy.cn/20250204/b9d0a2ad832c48d990695fd44955cb97.png) no-repeat center bottom;
			width: 100%;
			position: relative;
			text-align: center;
			order: 2;
			.list_title_box {
				padding: 0;
				margin: 0;
				background: url(http://codegen.caihongy.cn/20250423/45933adff10449008a6f3847926503fd.png) no-repeat center bottom;
				width: 100%;
				position: relative;
				text-align: center;
				height: 60px;
				.list_title {
					margin: 0 auto;
					color: rgb(0, 78, 162);
					background: none;
					font-weight: 600;
					display: block;
					letter-spacing: 1px;
					width: auto;
					font-size: 32px;
					line-height: 60px;
					text-align: center;
				}
				.list_subhead {
					margin: 0;
					color: #999;
					display: none;
					width: 100%;
					font-size: 18px;
					line-height: 40px;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list18 {
				margin: 0 auto;
				color: #333;
				background: none;
				font-weight: 500;
				width: 1300px;
				font-size: 14px;
				.tab_view {
					margin: 10px auto;
					display: none;
					width: 60%;
					justify-content: center;
					.tab {
						cursor: pointer;
						border-radius: 5px;
						margin: 0 5px 10px;
						color: #333;
						background: #eee;
						display: block;
						width: 140px;
						font-size: 14px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
					.tab:hover {
						color: #ddd;
						background: #0195df;
					}
					.tab.tabActive {
						color: #fff;
						background: #5555ff;
					}
				}
				.list-body {
					padding: 0;
					margin: 30px 0 0;
					display: flex;
					width: 100%;
					.list-body-left {
						margin: 0 auto 0 0;
						width: 59%;
						.list-item1 {
							border: 1px solid rgb(45, 50, 64);
							border-radius: 10px;
							margin: 0 0 20px;
							overflow: hidden;
							display: flex;
							width: 100%;
							align-items: center;
							transition: all 0s;
							.infoBox {
								border: 1px solid #eee;
								cursor: pointer;
								padding: 12px;
								background: #fff;
								width: 50%;
								height: 225px;
								.name {
									overflow: hidden;
									color: #000;
									white-space: nowrap;
									font-weight: 600;
									width: 100%;
									font-size: 15px;
									line-height: 1.5;
									text-overflow: ellipsis;
								}
								.price {
									padding: 5px 0;
									color: #f00;
									font-size: 16px;
									line-height: 1.5;
								}
								.time_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.publisher_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.like_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										color: #000;
										font-size: 12px;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.collect_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.view_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
							}
							.img {
								overflow: hidden;
								width: 50%;
								transition: all .3s;
								height: 225px;
								img {
									transform: scale(1);
									object-fit: cover;
									display: block;
									width: 100%;
									transition: all .3s;
									height: 100%;
								}
							}
						}
						.list-item1:hover {
							.infoBox {
								background: #fff;
								.name {
								}
								.price {
								}
								.time_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.publisher_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.like_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.collect_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.view_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
							}
							.img {
								cursor: pointer;
								overflow: hidden;
								img {
									transform: scale(1.2);
								}
							}
						}
						.list-item2 {
							border: 1px solid rgb(45, 50, 64);
							border-radius: 10px;
							overflow: hidden;
							display: flex;
							width: 100%;
							align-items: center;
							transition: all 0s;
							.img {
								overflow: hidden;
								width: 50%;
								transition: all .3s;
								height: 225px;
								img {
									transform: scale(1);
									object-fit: cover;
									display: block;
									width: 100%;
									transition: all .3s;
									height: 100%;
								}
							}
							.infoBox {
								border: 1px solid #eee;
								cursor: pointer;
								padding: 12px;
								background: #fff;
								width: 50%;
								height: 225px;
								.name {
									overflow: hidden;
									color: #000;
									white-space: nowrap;
									font-weight: 600;
									width: 100%;
									font-size: 15px;
									line-height: 1.5;
									text-overflow: ellipsis;
								}
								.price {
									padding: 5px 0;
									color: #f00;
									font-size: 16px;
									line-height: 1.5;
								}
								.time_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.publisher_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.like_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.collect_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.view_item {
									padding: 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
							}
						}
						.list-item2:hover {
							transform: translate3d(0px, 0px, 0px);
							.img {
								cursor: pointer;
								overflow: hidden;
								img {
									transform: scale(1.2);
								}
							}
							.infoBox {
								background: #fff;
								.name {
								}
								.price {
								}
								.time_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.publisher_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.like_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.collect_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
								.view_item {
									.icon {
									}
									.label {
									}
									.text {
									}
								}
							}
						}
					}
					.list-body-right {
						width: 39%;
						.list-item {
							cursor: pointer;
							width: 100%;
							position: relative;
							.img {
								width: 100%;
								height: 470px;
								img {
									transform: scale(1);
									object-fit: cover;
									display: block;
									width: 100%;
									transition: all .3s;
									height: 100%;
								}
							}
							.infoBox {
								padding: 12px 12px 38px;
								color: #eee;
								left: 0;
								bottom: 0;
								background: rgba(0, 0, 0, .3);
								width: 100%;
								position: absolute;
								.name {
									overflow: hidden;
									color: #fff;
									white-space: nowrap;
									font-weight: 600;
									width: 100%;
									font-size: 15px;
									line-height: 1.5;
									text-overflow: ellipsis;
								}
								.price {
									padding: 10px;
									color: #f00;
									font-size: 16px;
									line-height: 1.5;
								}
								.time_item {
									padding: 0 10px 0 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.publisher_item {
									padding: 0 10px 0 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.like_item {
									padding: 0 10px 0 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.collect_item {
									padding: 0 10px 0 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.view_item {
									padding: 0 10px 0 0;
									display: inline-block;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
							}
						}
						.swiper-button-prev {
							left: 10px;
							right: auto;
						}
						.swiper-button-prev::after {
							color: #d7b830;
						}
						.swiper-button-next {
							left: auto;
							right: 10px;
						}
						.swiper-button-next::after {
							color: #d7b830;
						}
						/deep/.swiper-pagination {
							transform: translate3d(0,0,0);
							z-index: 10;
							left: 0;
							bottom: 10px;
							width: 100%;
							position: absolute;
							transition: .3s opacity;
							text-align: center;
							.swiper-pagination-bullet {
								cursor: pointer;
								border-radius: 100%;
								margin: 0 4px;
								background: #eee;
								display: inline-block;
								width: 8px;
								opacity: .8;
								height: 8px;
							}
							.swiper-pagination-bullet:hover {
								background: #f7db61;
							}
							.swiper-pagination-bullet.swiper-pagination-bullet-active {
								background: #f7db61;
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0px solid #999;
				cursor: pointer;
				border-radius: 0;
				padding: 0 20px;
				margin: 30px auto 40px;
				background: rgb(0, 78, 162);
				display: inline-block;
				width: 250px;
				line-height: 48px;
				text-align: center;
				.text {
					color: #fff;
					font-size: 16px;
				}
				.icon {
					color: #fff;
					font-size: 16px;
				}
			}
		}
	}
</style>
