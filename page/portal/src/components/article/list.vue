<template>
	<div>
		<div class="article_container">
			<div class="article_water_fall">
				<div class="article" v-for="article in articleList">
					<p class="article_title">{{article.title}}</p>
					<div class="article_context" v-html='article.context'>
					</div>
					<p class="article_info">
						<span class="fa fa-user-o">{{article.author}}</span>
						<span class="fa fa-calendar">{{article.time}}</span>
						<span class="fa fa-comments-o">{{article.comments}}</span>
					</p>
				</div>
			</div>
		</div>
	</div>
		

</template>

<script>
	import * as types from '../../store/types';
	import axiosInstance from '../../util/http';
	import leftNav from '../nav/leftNav.vue';
	import topNav from '../nav/topNav.vue';
	export default {
		name: 'articleList',
		data() {
			return {
				articleList: [
				{
						title: 'NIO 概述',
						context: 'Java NIO 由以下几个核心部分组成：Channels、Buffers、Selectors虽然Java NIO 中除此之外还有很多类和组件，但在我看来，Channel，Buffer 和 Selector 构成了核心的API。其它组件，如Pipe和FileLock，只不过是与三个核心组件共同使用的工具类。因此，在概述中我将集中在这三个组件上。其它组件会在单独的章节中讲到。',
						author: 'z',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO Channel',
						context: 'Java NIO的通道类似流，但又有些不同：既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。通道可以异步地读写。通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。正如上面所说，从通道读取数据到缓冲区，从缓冲区写入数据到通道。',
						author: 'sangaizhi',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'BIO Buffer',
						context: 'Java NIO中的Buffer用于和NIO通道进行交互。如你所知，数据是从通道读入缓冲区，从缓冲区写入到通道中的。缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO Scatter与Gather',
						context: 'Java NIO开始支持scatter/gather，scatter/gather用于描述从Channel（译者注：Channel在中文经常翻译为通道）中读取或者写入到Channel的操作。分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。scatter / gather经常用于需要将传输的数据分开处理的场合，例如传输一个由消息头和消息体组成的消息，你可能会将消息体和消息头分散到不同的buffer中，这样你可以方便的处理消息头和消息体。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO 通道之间的数据传输',
						context: '在Java NIO中，如果两个通道中有一个是FileChannel，那你可以直接将数据从一个channel（译者注：channel中文常译作通道）传输到另外一个channel。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO Selector',
						context: 'Selector（选择器）是Java NIO中能够检测一到多个NIO通道，并能够知晓通道是否为诸如读写事件做好准备的组件。这样，一个单独的线程可以管理多个channel，从而管理多个网络连接。',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO FileChannel',
						context: 'Java NIO中的FileChannel是一个连接到文件的通道。可以通过文件通道读写文件。FileChannel无法设置为非阻塞模式，它总是运行在<font color=red>阻塞模式</font>下。<br/> 1、打开FileChannel <br/>2、从FileChannel读取数据<br/>3、向FileChannel写数据',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO  SocketChannel',
						context: 'Java NIO中的SocketChannel是一个连接到TCP网络套接字的通道。可以通过以下2种方式创建SocketChannel：</br>打开一个SocketChannel并连接到互联网上的某台服务器。</br>一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO ServerSocketChannel',
						context: 'Java NIO中的 ServerSocketChannel 是一个可以监听新进来的TCP连接的通道, 就像标准IO中的ServerSocket一样。ServerSocketChannel类在 java.nio.channels包中。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO Java NIO DatagramChannel',
						context: 'Java NIO中的DatagramChannel是一个能收发UDP包的通道。因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。它发送和接收的是数据包。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO Pipe',
						context: 'Java NIO 管道是2个线程之间的单向数据连接。Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					},
					{
						title: 'NIO 优点',
						context: '优点：<br/>1：客户端发起的连接操作是异步的，可以通过在多路复用器注册OP_CONNECT等待后续结果， 不会被同步阻塞。<br/>2：SocketChannel 的读写操作都是异步的，如果没有可读写的数据它不会同步等待，直接返回，这样 I/O 通信线程就可以处理其他的链路，不需要同步等待这个链路可用。<br/>3：线程模型的优化：由于JDK的Selector在Linux等主流操作系统上通过epoll实现，它没有连接句柄的限制（只受限于操作系统的最大句柄数或者单个进程的句柄限制），这意味着一个Selector线程可以同时处理成千上万个客户端连接，而且性能不会随着客户端的增加而线性下降。因此，它非常适合做高性能，该负载的网络服务器。',
						author: '测试',
						time: '2017-12-13',
						comments: '10'
					}
				],
				categoryId: this.$route.params.categoryId
			};
		},
		mounted() {},
		components: {leftNav,topNav}
	}
</script>

<style>
	.article_container {
		width: 100%;
		    height: 100%;
    overflow: auto;
	}
	
	.article_water_fall {
		-moz-column-count: 4;
		/* Firefox */
		-webkit-column-count: 4;
		/* Safari 和 Chrome */
		column-count: 4;
		/* 用整数值来定义列数。不允许负值 */
		-moz-column-gap: 1em;
		-webkit-column-gap: 1em;
		column-gap: 1em;
		/*用长度值来定义列与列之间的间隙。不允许负值*/
		float: left;
		padding: 20px;
	}
	
	.article {
		padding: 1em;
		margin: 0 0 1em 0;
		-moz-page-break-inside: avoid;
		-webkit-column-break-inside: avoid;
		break-inside: avoid;
		/*margin: 10px 20px;*/
		border-radius: 5px;
		background: #FFFFFF;
		/*padding: 30px 30px 5px 30px;*/
		color: #58666e;
	}
	
	.article .article_title {
		display: inline-block;
		line-height: 25px;
		overflow: hidden;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
		font-size: 18px;
		width: 100%;
		text-align: left;
		margin: 0;
	}
	
	.article .article_context {
		text-align: left;
		font-size: 12px;
		word-break: break-all!important;
		margin-bottom: 30px;
		margin-top: 20px;
	}
	
	.article .article_info {
		font-size: 12px;
		padding-top: 10px;
		text-align: left;
		height: 30px;
		line-height: 30px;
		border-top: 1px solid #edf1f2;
		margin: 0;
	}
	
	.article .article_info span {
		margin-right: 15px;
		;
	}
	
	.article .article_info span:before {
		padding-right: 10px;
	}
</style>