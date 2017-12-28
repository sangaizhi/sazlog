<template>
	<div class="content-container">
		<router-view class='view' name='container'></router-view>
	</div>
</template>

<script>
</script>

<style>
	.content-container{
		position: absolute;
		width: 100%;
		height: 100%;
		left: 200px;
		top:50px;
		bottom: 0;
		right: 0;
		background-color: #f0f3f4;
	}
</style>