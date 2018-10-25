package com.dayu.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dayu.R;

public class PageWidgetAdapter extends BaseAdapter {

	private Context mContext;
	private int count;
	private LayoutInflater inflater;
	/*private Integer[] imgs = { R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
			  R.drawable.photo4, R.drawable.photo5, R.drawable.photo6};*/
	private String[] texts = {"乡下真是美。到了夏天！小麦是金黄的，燕麦是绿油油的。干草在绿色的牧场上堆成垛，鹳（guan）鸟用它又长又红的腿子在散着步，噜嗦地讲着埃及话。（注：因为据丹麦的民间的传说，鹳鸟是从埃及飞来的。）这是它从妈妈那儿学到的一种语言。田野和牧场的周围有些大森林，森林里有些很深的池塘。的确，乡间是非常美丽的，太阳光正照着一幢老式的房子，它周围流着几条很深的小溪。从墙角那儿一直到水里，全盖满了牛蒡的大叶子。最大的叶子长得非常高，小孩子简直可以直着腰站在下面。像在最浓密的森林里一样，这儿也是很荒凉的。这儿有一只母鸭坐在窠里，她得把她的几个小鸭都孵出来。不过这时她已经累坏了。很少有客人来看她。别的鸭子都愿意在溪流里游来游去，而不愿意跑到牛蒡下面来和她聊天！\n" +
	"他们的眼睛是有好处的。“这个世界真够大！”这些年轻的小家伙说。的确，比起他们在蛋壳里的时候，他们现在的天地真是大不相同了。“你们以为这就是整个世界！”妈妈说。“这地方伸展到花园的另一边，一直伸展到牧师的田里去，才远呢！连我自己都没有去过！我想你们都在这儿吧？”她站起来。“没有，我还没有把你们都生出来呢！这只顶大的蛋还躺着没有动静。它还得躺多久呢？我真是有些烦了。”于是她又坐下来。“唔，情形怎样？”一只来拜访她的老鸭子问。“这个蛋费的时间真久！”坐着的母鸭说。“它老是不裂开。请你看看别的吧。他们真是一些最逗人爱的小鸭儿！都像他们的爸爸——这个坏东西从来没有来看过我一次！”“让我瞧瞧这个老是不裂开的蛋吧，”这位年老的客人说，“请相信我，这是一只吐绶鸡的蛋。有一次我也同样受过骗，你知道，那些小家伙不知道给了我多少麻烦和苦恼，因为他们都不敢下水。我简直没有办法叫他们在水里试一试。我说好说歹，一点用也没有！——让我来瞧瞧这只蛋吧。哎呀！这是一只吐绶鸡的蛋！让他躺着",
	"吧，你尽管叫别的孩子去游泳好了。”“我还是在它上面多坐一会儿吧，”鸭妈妈说，“我已经坐了这么久，就是再坐它一个星期也没有关系。”“那么就请便吧，”老鸭子说。于是她就告辞了。\n" +
			"　　最后这只大蛋裂开了。“噼！噼！”新生的这个小家伙叫着向外面爬。他是又大又丑。鸭妈妈把他瞧了一眼。“这个小鸭子大得怕人，”她说，“别的没有一个像他；但是他一点也不像小吐绶鸡！好吧，我们马上就来试试看吧。他得到水里去，我踢也要把他踢下水去。”第二天的天气是又晴和，又美丽。太阳照在绿牛蒡上。鸭妈妈带着她所有的孩子走到溪边来。扑通！她跳进水里去了。“呱！呱！”她叫着，于是小鸭子就一个接着一个跳下去。水淹到他们头上，但是他们马上又冒出来了，游得非常漂亮。他们的小腿很灵活地划着。他们全都在水里，连那个丑陋的灰色小家伙也跟他们在一起游。\n" +
			"　　“唔，他不是一个吐绶鸡，”她说，“你看他的腿划得多灵活，他浮得多么稳！他是",
	"我亲生的孩子！如果你把他仔细看一看，他还算长得蛮漂亮呢。嘎！嘎！跟我一块儿来吧，我把你们带到广大的世界上去，把那个养鸡场介绍给你们看看。不过，你们得紧贴着我，免得别人踩着你们。你们还得当心猫儿呢！”\n" +
			"　　这样，他们就到养鸡场里来了。场里响起了一阵可怕的喧闹声，因为有两个家族正在争夺一个鳝鱼头，而结果猫儿却把它抢走了。“你们瞧，世界就是这个样子！”鸭妈妈说。她的嘴流了一点涎水，因为她也想吃那个鳝鱼头。“现在使用你们的腿吧！”她说。“你们拿出精神来。你们如果看到那儿的一个老母鸭，你们就得把头低下来，因为她是这儿最有声望的人物。她有西班牙的血统——因为她长得非常胖。你们看，她的腿上有一块红布条。这是一件非常出色的东西，也是一个鸭子可能得到的最大光荣：它的意义很大，说明人们不愿意失去她，动物和人统统都得认识她。打起精神来吧——不要把腿子缩进去。一个有很好教养的鸭子总是把腿摆开的，像爸爸和妈妈一样。好吧，低下头来，说：‘嘎",
			"’呀！”他们这样做了。别的鸭子站在旁边看着，同时用相当大的声音说：“瞧！现在又来了一批找东西吃的客人，好像我们的人数还不够多似的！呸！瞧那只小鸭的一副丑相！我们真看不惯！”于是马上有一只鸭子飞过去，在他的脖颈上啄了一下。“请你们不要管他吧，”妈妈说，“他并不伤害谁呀！”“对，不过他长得太大、太特别了，”啄过他的那只鸭子说，“因此他必须挨打！”“那个母鸭的孩子都很漂亮，”腿上有一条红布的那个母鸭说，“他们都很漂亮，只有一只是例外。这真是可惜。我希望能把他再孵一次。”\n" +
					"　　“那可不能，太太，”鸭妈妈回答说，“他不好看，但是他的脾气非常好。他游起水来也不比别人差——我还可以说，游得比别人好呢。我想他会慢慢长得漂亮的，或者到适当的时候，他也可能缩小一点。他在蛋里躺得太久了，因此他的模样有点不太自然。”她说着，同时在他的脖颈上啄了一下，把他的羽毛理了一理。“此外，他还是一只公鸭呢，”她说，“所以关系也不太大。我想他的身体很结实，将来总会自己找到出路的。”“别",
			"的小鸭倒很可爱，”老母鸭说，“你在这儿不要客气。如果你找到鳝鱼头，请把它送给我好了。”他们现在在这儿，就像在自己家里一样。\n" +
					"　　不过从蛋壳里爬出的那只。\n" +
					"　　“他真是又大又丑！”大家都说。有一只雄吐绶鸡生下来脚上就有距，因此他自以为是一个皇帝。他把自己吹得像一条鼓满了风的帆船，来势汹汹地向他走来，瞪着一双大眼睛，脸上涨得通红。这只可怜的小鸭不知道站在什么地方，或者走到什么地方去好。他觉得非常悲哀，因为自己长得那么丑陋，而且成了全体鸡鸭的一个嘲笑对象。\n" +
					"　　这是头一天的情形。后来一天比一天糟。大家都要赶走这只可怜的小鸭；连他自己的兄弟姊妹也对他生气起来。他们老是说：“你这个丑妖怪，希望猫儿把你抓去才好！”于是妈妈也说起来：“我希望你走远些！”鸭儿们啄他。小鸡打",
	"fdfsdfdsfsd","dsfdssdf"};

	public PageWidgetAdapter(Context context) {
		mContext = context;
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		count = (int) Math.ceil(texts.length/2.0);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return texts[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewGroup layout;
		if(convertView == null) {
			layout = (ViewGroup) inflater.inflate(R.layout.item_layout, null);
		} else {
			layout = (ViewGroup) convertView;
		}
		setViewContent(layout, position);
		
		return layout;
	}
	
	private void setViewContent(ViewGroup group, int position) {
		TextView text = (TextView) group.findViewById(R.id.item_layout_leftText);
		text.setText(String.valueOf(position*2+1));
		TextView image = (TextView) group.findViewById(R.id.item_layout_left);
		image.setText(texts[position*2]);
		text = (TextView) group.findViewById(R.id.item_layout_rightText);
		text.setText(String.valueOf(position*2+2));
		image = (TextView) group.findViewById(R.id.item_layout_right);
		image.setText(texts[position*2]);
	}

}
